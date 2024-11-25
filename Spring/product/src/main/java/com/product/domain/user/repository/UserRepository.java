package com.product.domain.user.repository;

import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.User;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository {

    private final EntityManager em;

    public User save(User user) {
        if (!findByLoginId(user.getLoginId()).isEmpty()) {
            throw new DuplicateLoginIdException(user.getLoginId() + "는 이미 사용중입니다.");
        }
        em.persist(user);
        return user;
    }

    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(em.find(User.class, userId));
    }

    public Optional<User> findByLoginId(String loginId) {
        return em.createQuery("SELECT u FROM User AS u WHERE loginId = :loginId", User.class)
                .setParameter("loginId", loginId)
                .getResultStream()
                .findFirst();
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User AS u", User.class)
                .getResultList();
    }

    public void update(Long id, User user) {
        User existingUser = findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        existingUser.editUserInfo(user.getPassword(), user.getEmail(), user.getName());
    }

    public void delete(User user) {
        User existingUser = findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        em.remove(existingUser);
    }
}
