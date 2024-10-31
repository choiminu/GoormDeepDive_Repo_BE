package com.board.myboard.controller;

import com.board.myboard.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String home(@SessionAttribute(name = "member", required = false) Member member, Model model) {
        model.addAttribute("member", member);
        return "home";
    }
}
