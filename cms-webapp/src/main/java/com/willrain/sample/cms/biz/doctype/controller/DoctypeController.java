package com.willrain.sample.cms.biz.doctype.controller;

import com.willrain.sample.cms.biz.admin.dto.DepartmentModel;
import com.willrain.sample.cms.biz.board.dto.SampleBoardModel;
import com.willrain.sample.cms.biz.doctype.dto.DoctypeModel;
import com.willrain.sample.cms.biz.doctype.service.DoctypeService;
import com.willrain.sample.cms.common.code.ResultCode;
import com.willrain.sample.cms.common.controller.BaseController;
import com.willrain.sample.cms.common.exception.BizException;
import com.willrain.sample.cms.common.user.UserInfo;
import com.willrain.sample.cms.common.utils.ResponseEntityUtil;
import com.willrain.sample.cms.fileupload.storage.FileSystemStorageService;
import com.willrain.sample.cms.fileupload.storage.StorageFileNotFoundException;
import com.willrain.sample.cms.fileupload.storage.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 취합문서 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/doctype")
public class DoctypeController extends BaseController {
    private final DoctypeService doctypeService;
    private final FileSystemStorageService fileSystemStorageService;

    @ModelAttribute("doctypeNameMap")
    public Map<String, String> doctypeName() throws Exception {
        List<DoctypeModel> models = doctypeService.getList(100);
        Map<String, String> doctypeName = new LinkedHashMap<>();
        for (DoctypeModel model : models) {
            doctypeName.put(model.getDoctypeId(), model.getDoctypeName());
        }
        return doctypeName;
    }

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/index");
        return mv;
    }

    @GetMapping(path = "/{docId}")
    public ModelAndView getDocument(@PathVariable(name = "docId") String docId) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/detail");

        mv.addObject("docId", docId);
        return mv;
    }

    //취합 문서 정보 수정페이지
    @GetMapping(path = "/doc-reg")
    public ModelAndView docReg(Pageable page) throws Exception {

        ModelAndView mv = new ModelAndView("cms/doctype/doc-reg");
        mv.addObject("doctypeModel", new DoctypeModel());

        return mv;
    }

    //취합 문서 양식 정보 가져오기 필요없을듯>?
    @GetMapping("/doc-reg/{doctypeId}")
    public ResponseEntity<DoctypeModel> getDoctype(@PathVariable("doctypeId") String id) throws Exception {
        log.info("# getDoctype data : doctypeId  = {}", id);
        DoctypeModel doctypeModel = doctypeService.getDetail(id);
        return ResponseEntityUtil.ok(doctypeModel);
    }
    //취합 문서 양식 수정
    @PostMapping("/doc-reg")
    public String modifyDoctype(@ModelAttribute DoctypeModel param) throws Exception {
        log.info("#doctype modify() : doctypeId = {}, body = {}", param.getDoctypeId(), param);

        // 수정 대상 데이터 조회
        DoctypeModel doctypeModel = doctypeService.getDetail(param.getDoctypeId());

        log.info("# doctypeModel1 : {} ", doctypeModel);

        // 권한 검사
//        Optional.ofNullable(doctypeModel.getCreatedId())
//                .filter(s -> s.equals(userInfo.getId()))
//                .orElseThrow(() -> new BizException(ResultCode.HTTP_403, "관리자만 수정 가능"));

        //파일 저장
        String savedPath = fileSystemStorageService.store(param.getUploadFile());

        // 수정 항목 맵핑
//        Optional.ofNullable(param.getSampleFileUri()).ifPresent(s -> doctypeModel.setSampleFileUri(s));
        Optional.ofNullable(savedPath).ifPresent(s -> doctypeModel.setSampleFileUri(s));
        Optional.ofNullable(param.getDoctypeNote()).ifPresent(s -> doctypeModel.setDoctypeNote(s));

        doctypeService.modify(doctypeModel);

        return "redirect:/cms/doctype/doc-reg";
    }

//    @GetMapping(path = "/set-input-person")
//    public ModelAndView setInputPerson(Pageable page) throws Exception {
//        ModelAndView mv = new ModelAndView("cms/doctype/set-input-person");
//        return mv;
//    }

    @GetMapping(path = "/docs-status")
    public ModelAndView docsStatus(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/docs-status");
        return mv;
    }


}

