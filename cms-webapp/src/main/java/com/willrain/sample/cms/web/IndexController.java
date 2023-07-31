package com.willrain.sample.cms.web;

import com.willrain.sample.cms.common.controller.BaseController;
import com.willrain.sample.cms.common.user.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
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


    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @PostMapping("login-process")
    public String loginProcess(UserInfo userInfo) {
        log.info("# login Process : userInfo = {}", userInfo);
        return "index";
    }

    @GetMapping("login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "loginForm";
    }

}
