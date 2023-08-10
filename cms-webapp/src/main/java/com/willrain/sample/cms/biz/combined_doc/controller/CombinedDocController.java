package com.willrain.sample.cms.biz.combined_doc.controller;

import com.willrain.sample.cms.biz.combined_doc.dto.CombinedDocModel;
import com.willrain.sample.cms.biz.combined_doc.mapper.CombinedDocService;
import com.willrain.sample.cms.common.controller.BaseController;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/combined_doc")
public class CombinedDocController extends BaseController {
    private  final CombinedDocService combinedDocService;

    @ModelAttribute("combinedDocMap")
    public Map<String, String> combinedDoc() throws Exception {
        List<CombinedDocModel> models = combinedDocService.getList(100);
        return combinedDoc();
    }

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable page) throws  Exception {
        ModelAndView mv = new ModelAndView("cms/combined_doc/index");
        return mv;
    }






}
