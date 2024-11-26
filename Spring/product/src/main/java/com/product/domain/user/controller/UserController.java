package com.product.domain.user.controller;

import com.product.domain.user.model.Address;
import com.product.domain.user.model.User;
import com.product.domain.user.service.UserService;
import com.product.utils.FileStore;
import java.net.MalformedURLException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FileStore fileStore;

    @GetMapping("/myPage")
    public String myPage(@SessionAttribute(name = "loginUser") User user, Model model) {
        if (user != null) {
            User foundUser = userService.findById(user.getId());
            model.addAttribute("user", foundUser);
        }
        return "user/userInfo";
    }

}
