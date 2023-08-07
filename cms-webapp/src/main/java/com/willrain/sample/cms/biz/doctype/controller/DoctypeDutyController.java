package com.willrain.sample.cms.biz.doctype.controller;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyModel;
import com.willrain.sample.cms.biz.doctype.dto.DoctypeModel;
import com.willrain.sample.cms.biz.doctype.service.DoctypeDutyService;
import com.willrain.sample.cms.common.controller.BaseController;
import com.willrain.sample.cms.common.dto.PageEntity;
import com.willrain.sample.cms.common.utils.ResponseEntityUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/doctype/set-input-person")
public class DoctypeDutyController extends BaseController {
    private final DoctypeDutyService doctypeDutyService;

    @ModelAttribute("docObject")
    public DoctypeDutyModel docObject() {
        return new DoctypeDutyModel();
    }

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable pageable) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/set-input-person");
        PageEntity<DoctypeDutyModel> pageEntity = doctypeDutyService.getListWithConcat(new PageEntity<>(pageable));
        log.info("pageEntity = {}", pageEntity);

        mv.addObject("pageEntity", pageEntity);
        return mv;
    }

    @GetMapping("/{doctypeId}")
    public ResponseEntity<DoctypeDutyModel> getDutyByDoctypeId(@PathVariable("doctypeId") String id, Pageable pageable) throws Exception {
        log.info("# getDoctype data : doctypeId  = {}", id);
        PageEntity<DoctypeDutyModel> pageEntity = new PageEntity(pageable);
        DoctypeDutyModel model = new DoctypeDutyModel();
        model.setDoctypeId(id);
        pageEntity.setSearchDto(model);
        PageEntity<DoctypeDutyModel> list = doctypeDutyService.getList(pageEntity);

        return ResponseEntityUtil.ok(list);
    }

//    @GetMapping("/{doctypeId}")
//    public ModelAndView getDutyByDoctypeId(@PathVariable("doctypeId") String id, Pageable pageable) throws Exception {
//        log.info("# getDoctype data : doctypeId  = {}", id);
//        PageEntity<DoctypeDutyModel> pageEntity = new PageEntity(pageable);
//        DoctypeDutyModel model = new DoctypeDutyModel();
//        model.setDoctypeId(id);
//        pageEntity.setSearchDto(model);
//        PageEntity<DoctypeDutyModel> list = doctypeDutyService.getList(pageEntity);
//        ModelAndView mv = new ModelAndView("/cms/doctype/set-input-person");
//        mv.addObject("docObject", list);
//
//        return mv;
//    }

}
