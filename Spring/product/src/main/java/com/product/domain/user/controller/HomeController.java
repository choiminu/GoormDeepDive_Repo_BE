package com.product.domain.user.controller;

import com.product.domain.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(@SessionAttribute(name = "loginUser", required = false) User user, Model model) {
        if (user != null) {
            model.addAttribute("isLogin", true);
            return "main";
        }
        model.addAttribute("isLogin", false);
        return "main";
    }

}
