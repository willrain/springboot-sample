
package com.willrain.sample.cms.biz.admin.controller;

import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.biz.admin.service.AdminService;
import com.willrain.sample.cms.common.controller.BaseController;
import com.willrain.sample.cms.common.dto.PageEntity;
import com.willrain.sample.cms.common.utils.ResponseEntityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/admin/user")
public class AdminController extends BaseController {
    private final AdminService adminService;

    @GetMapping(path = {"", "/"})
    public String index(Pageable pageable, Model model) throws Exception {

        PageEntity<AdminModel> pageEntity = adminService.getList(new PageEntity<>(pageable));

        log.info("pageEntity = {}", pageEntity);
        model.addAttribute("mbrList", pageEntity);

        return "cms/admin/index";
    }
//    @GetMapping("/api")
//    public ResponseEntity<List<AdminModel>> getList(Pageable page, AdminModel model) throws Exception {
//        log.info("# AdminModel = {}", model);
//        PageEntity pageEntity = new PageEntity(page);
//        pageEntity.setSearchDto(model);
//
//        PageEntity<AdminModel> entity = adminService.getList(pageEntity);
//
//        return ResponseEntityUtil.ok(entity);
//
//    }


}
