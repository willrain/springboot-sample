package com.willrain.sample.cms.biz.doctype.controller;

import com.willrain.sample.cms.biz.doctype.dto.DoctypeDutyModel;
import com.willrain.sample.cms.biz.doctype.service.DoctypeDutyService;
import com.willrain.sample.cms.common.controller.BaseController;
import com.willrain.sample.cms.common.dto.PageEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/doctype/set-input-person")
public class DoctypeDutyController extends BaseController {
    private final DoctypeDutyService doctypeDutyService;

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable pageable) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/set-input-person");
            log.info("in doctype duty controller");
        PageEntity<DoctypeDutyModel> pageEntity = doctypeDutyService.getList(new PageEntity<>(pageable));
        log.info("pageEntity = {}", pageEntity);

        mv.addObject("pageEntity", pageEntity);
        return mv;
    }
}
