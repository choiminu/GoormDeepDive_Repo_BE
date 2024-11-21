package com.dbexplorer.repository;

import com.dbexplorer.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByLoginId(String loginId);
    List<Member> findAll();
    Member update(Long id, Member member);
    boolean delete(Long id);
}
