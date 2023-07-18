package com.willrain.sample.cms.biz.input.controller;

import com.willrain.sample.cms.common.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 입력 문서 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/input")
public class InputController extends BaseController {

    @GetMapping(path = "/docs-status")
    public ModelAndView docsStatus(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/input/docs-status");
        return mv;
    }

    @GetMapping(path = "/{inputId}")
    public ModelAndView getDocument(@PathVariable(name = "inputId") String inputId) throws Exception {
        ModelAndView mv = new ModelAndView("cms/input/detail");

        mv.addObject("inputId", inputId);
        return mv;
    }
}
