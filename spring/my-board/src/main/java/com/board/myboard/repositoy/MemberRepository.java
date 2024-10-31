package com.board.myboard.repositoy;

import com.board.myboard.model.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByloginId(String loginId);
}
