package com.board.myboard.service;

import com.board.myboard.model.Member;
import com.board.myboard.repositoy.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member login(String loginId, String password) {
        return memberRepository.findByloginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
