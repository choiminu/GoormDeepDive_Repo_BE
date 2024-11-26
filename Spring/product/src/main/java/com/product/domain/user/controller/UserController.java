package com.product.domain.user.controller;

import com.product.domain.user.model.User;
import com.product.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/my-page")
    public String myPage(@SessionAttribute(name = "loginMember", required = true) User user ) {
        return "/";
    }

}
