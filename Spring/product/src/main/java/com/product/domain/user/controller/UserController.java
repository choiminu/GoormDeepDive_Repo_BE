package com.product.domain.user.controller;

import com.product.domain.user.dto.RequestUserSave;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.service.UserService;
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

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("join") RequestUserSave requestUserSave) {
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("join") RequestUserSave requestUserSave,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/join";
        }

        if (handleDuplicateLoginId(requestUserSave, bindingResult)) {
            return "user/join";
        }

        userService.join(requestUserSave);
        return "redirect:/";
    }


    private boolean handleDuplicateLoginId(RequestUserSave requestUserSave, BindingResult bindingResult) {
        try {
            userService.join(requestUserSave);
            return false;
        } catch (DuplicateLoginIdException e) {
            bindingResult.reject("duplicateLoginId", "이미 사용중인 아이디입니다.");
            return true;
        }
    }
}
