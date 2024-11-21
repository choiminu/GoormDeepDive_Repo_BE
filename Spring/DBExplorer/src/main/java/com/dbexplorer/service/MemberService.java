package com.dbexplorer.service;

import com.dbexplorer.domain.Member;
import com.dbexplorer.domain.MemberCreateRequest;
import com.dbexplorer.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(MemberCreateRequest memberCreateRequest) {
        Member member = Member.builder()
                .id(null)
                .loginId(memberCreateRequest.getLoginId())
                .password(memberCreateRequest.getPassword())
                .name(memberCreateRequest.getName()).build();
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member findByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId).orElse(null);
    }

    public Member updateMember(Long id, MemberCreateRequest memberCreateRequest) {
        Member member = Member.builder()
                .id(null)
                .loginId(memberCreateRequest.getLoginId())
                .password(memberCreateRequest.getPassword())
                .name(memberCreateRequest.getName()).build();
        return memberRepository.update(id, member);
    }

    public boolean deleteMember(Long id) {
        return memberRepository.delete(id);
    }
}
