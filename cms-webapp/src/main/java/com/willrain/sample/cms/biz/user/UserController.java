package com.willrain.sample.cms.biz.user;

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
 * 취합문서 관리
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cms/user")
public class UserController extends BaseController {

    @GetMapping(path = {"", "/"})
    public ModelAndView index(Pageable page) throws Exception {
        ModelAndView mv = new ModelAndView("cms/user/index");
        return mv;
    }

    @GetMapping(path = "/{userId}")
    public ModelAndView getUser(@PathVariable(name = "userId") int userId) throws Exception {
        ModelAndView mv = new ModelAndView("cms/user/detail");
        mv.addObject("userId", userId);
        return mv;
    }


}

