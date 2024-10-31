package com.board.myboard.controller;

import com.board.myboard.model.Member;
import com.board.myboard.model.dto.JoinRequest;
import com.board.myboard.model.dto.LoginRequest;
import com.board.myboard.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("login")
    public String loginForm(@ModelAttribute("form") LoginRequest form) {
        return "login/loginForm";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("form") LoginRequest form, BindingResult bindingResult,
                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = memberService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "ID 또는 PW 불일치");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("member", loginMember);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(@SessionAttribute(name = "member", required = false) Member member, HttpServletRequest request) {
        if (member != null) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("form") JoinRequest form) {
        return "member/memberJoinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute("form") JoinRequest form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/memberJoinForm";
        }

        Member member = new Member();
        member.setLoginId(form.getLoginId());
        member.setPassword(form.getPassword());
        member.setNickname(form.getNickName());
        memberService.join(member);

        return "redirect:/";
    }
}
