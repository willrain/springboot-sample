package com.willrain.sample.cms.web;

import com.willrain.sample.cms.common.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sysadmin/front")
public class IndexController extends BaseController {


    @GetMapping("/")
    public String root() {
        log.debug("# IN IndexController.root()");
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
