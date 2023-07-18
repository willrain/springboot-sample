package com.willrain.sample.cms.biz.manual.controller;

import com.willrain.sample.cms.common.controller.BaseController;
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
@RequestMapping("/cms/manual")
public class ManualController extends BaseController {

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/manual/index");
        return mv;
    }

    @GetMapping("/open-doc")
    public ModelAndView openDoc(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/manual/open-doc");
        return mv;
    }


}

