package com.dbexplorer.controller.member;

import com.dbexplorer.domain.Member;
import com.dbexplorer.domain.MemberCreateRequest;
import com.dbexplorer.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping()
    public Member join(@RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.join(memberCreateRequest);
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @GetMapping()
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @PatchMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.updateMember(id, memberCreateRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        if (memberService.deleteMember(id)) {
            return id + " 삭제 완료";
        }
        return id + " 삭제 실패";
    }
}
