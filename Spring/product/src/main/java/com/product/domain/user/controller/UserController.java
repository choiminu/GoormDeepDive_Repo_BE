package com.product.domain.user.controller;

import com.product.domain.user.dto.RequestUserLogin;
import com.product.domain.user.dto.RequestUserSave;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.User;
import com.product.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String joinForm(@ModelAttribute("join") RequestUserSave requestUserSave) {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String join(@Validated @ModelAttribute("join") RequestUserSave requestUserSave, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        try {
            userService.join(requestUserSave);
        } catch (DuplicateLoginIdException e) {
            bindingResult.reject("duplicateLoginId", "이미 사용중인 아이디 입니다.");
            return "user/signup";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") RequestUserLogin requestUserLogin) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginForm") RequestUserLogin requestUserLogin, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        User user = userService.login(requestUserLogin);
        if (user == null) {
            bindingResult.reject("loginFail","ID 또는 PW 에러");
            return "user/login";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loginUser", user);

        return "redirect:/";
    }
}
