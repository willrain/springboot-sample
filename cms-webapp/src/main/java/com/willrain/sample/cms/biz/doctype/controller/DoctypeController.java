package com.willrain.sample.cms.biz.doctype.controller;

import com.willrain.sample.cms.common.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 취합문서 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/doctype")
public class DoctypeController extends BaseController {

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

    @GetMapping(path = "/doc-reg")
    public ModelAndView docReg(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/doc-reg");
        return mv;
    }

    @GetMapping(path = "/set-input-person")
    public ModelAndView setInputPerson(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/set-input-person");
        return mv;
    }

    @GetMapping(path = "/docs-status")
    public ModelAndView docsStatus(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/doctype/docs-status");
        return mv;
    }


}

