package com.board.myboard;

import com.board.myboard.model.Member;
import com.board.myboard.repositoy.MemberRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DateInit {

    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("1234");
        member.setNickname("민우");
        memberRepository.save(member);
    }

}
