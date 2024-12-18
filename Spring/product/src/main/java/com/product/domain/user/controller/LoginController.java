package com.product.domain.user.controller;

import com.product.domain.user.dto.UserLoginRequest;
import com.product.domain.user.dto.UserSignupRequest;
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
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") UserLoginRequest userLoginRequest) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginForm") UserLoginRequest userLoginRequest,
                        BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        User user = userService.login(userLoginRequest);
        if (user == null) {
            bindingResult.reject("loginFail", "ID 또는 PW 에러");
            return "user/login";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loginUser", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(@SessionAttribute("loginUser") User user, HttpServletRequest request) {
        if (user != null) {
            HttpSession session = request.getSession(false);
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String joinForm(@ModelAttribute("join") UserSignupRequest userSignupRequest) {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String join(@Validated @ModelAttribute("join") UserSignupRequest userSignupRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        try {
            userService.signup(userSignupRequest);
        } catch (DuplicateLoginIdException e) {
            bindingResult.reject("duplicateLoginId", "이미 사용중인 아이디 입니다.");
            return "user/signup";
        }
        return "redirect:/";
    }
}
