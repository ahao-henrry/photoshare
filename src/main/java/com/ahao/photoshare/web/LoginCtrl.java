package com.ahao.photoshare.web;

import com.ahao.photoshare.aop.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginCtrl {

    @Action(name = "login")
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
