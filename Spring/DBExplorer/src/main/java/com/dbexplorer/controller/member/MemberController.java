package com.dbexplorer.controller.member;

import com.dbexplorer.domain.Member;
import com.dbexplorer.domain.MemberCreateRequest;
import com.dbexplorer.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String memberJoinForm(@ModelAttribute("member") MemberCreateRequest member) {
        return "members/join";
    }

    @PostMapping("/join")
    public String memberJoin(@Validated @ModelAttribute("member") MemberCreateRequest member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/join";
        }

        memberService.join(member);
        return "members/join";
    }

    @GetMapping
    public String memberList(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/members";
    }

    @GetMapping("/{id}")
    public String memberInfo(@PathVariable("id") Long id, Model model) {
        Member findMember = memberService.findById(id);
        model.addAttribute("member", findMember);
        return "members/member";
    }

    @GetMapping("/edit/{id}")
    public String memberUpdateForm(@PathVariable("id") Long id, Model model) {
        Member findMember = memberService.findById(id);
        model.addAttribute("member",findMember);
        return "members/update";
    }

    @PostMapping("/edit/{id}")
    public String memberUpdate(@PathVariable("id") Long id, @ModelAttribute MemberCreateRequest memberCreateRequest) {
        memberService.updateMember(id, memberCreateRequest);
        return "redirect:/members/" + id;
    }

}
