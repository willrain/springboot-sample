
package com.willrain.sample.cms.biz.admin.controller;

import com.willrain.sample.cms.biz.admin.dto.AdminModel;
import com.willrain.sample.cms.biz.admin.dto.DepartmentModel;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/admin/user")
public class AdminController extends BaseController {
    private final AdminService adminService;


    @ModelAttribute("authorCdMap")
    public Map<String, String> authorCd() {
        Map<String, String> authorCd = new LinkedHashMap<>();
        authorCd.put("A", "어드민");
        authorCd.put("Q", "취합자");
        authorCd.put("U", "입력자");
        return authorCd;
    }
    @ModelAttribute("useYnMap")
    public Map<String, String> useYn() {
        Map<String, String> useYn = new LinkedHashMap<>();
        useYn.put("Y", "활성화");
        useYn.put("N", "비활성화");
        return useYn;
    }

    @ModelAttribute("departmentMap")
    public Map<Long, String> department() {
        List<DepartmentModel> models = adminService.getDepartmentList();
        Map<Long, String> department = new LinkedHashMap<>();
        for (DepartmentModel model : models) {
            department.put(model.getDeptId(), model.getDeptName());
        }
        return department;
    }

    @GetMapping(path = {"", "/"})
    public String index(Pageable pageable, Model model) throws Exception {

        PageEntity<AdminModel> pageEntity = adminService.getList(new PageEntity<>(pageable));
//        PageEntity<DepartmentModel> pageEntity = adminService.getUserList(new PageEntity<>(pageable));

        log.info("pageEntity = {}", pageEntity);
        model.addAttribute("userList", pageEntity);

        return "cms/admin/index";
    }
    @GetMapping(path = {"/list"})
    public ResponseEntity<PageEntity<AdminModel>> getList(Pageable page, AdminModel searchDto) throws Exception {
        log.info("searchDto = {}", searchDto);
        PageEntity pageEntity = new PageEntity<>(page);
        pageEntity.setSearchDto(searchDto);

        PageEntity<AdminModel> entity = adminService.getListByDto(pageEntity);

        return ResponseEntityUtil.ok(entity);
    }

    @GetMapping("/{userId}")
    public String detail(@PathVariable("userId") String id, Model model) throws Exception {
        AdminModel adminModel = adminService.getDetail(id);
        log.info("adminModel = {}", adminModel);
        model.addAttribute("userDetail", adminModel);
        return "cms/admin/detail";
    }

    @PostMapping
    public String modify(@ModelAttribute AdminModel userDetail, RedirectAttributes redirectAttributes) throws Exception{
        log.info("AdminModel = {}", userDetail);
        AdminModel adminModel = adminService.modify(userDetail);

        return "redirect:/cms/admin/user";
//        redirectAttributes.addAttribute("userId", adminModel.getUserId()); //
//        return "redirect:/cms/admin/user/{userId}";
    }




//    @GetMapping("/api")
//    public ResponseEntity<List<AdminModel>> getListPageable(Pageable page, AdminModel model) throws Exception {
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
