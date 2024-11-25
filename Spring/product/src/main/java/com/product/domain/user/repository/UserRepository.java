package com.product.domain.user.repository;

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
        em.persist(user);
        return user;
    }

    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(em.find(User.class, userId));
    }

    public List<User> findByLoginId(String loginId) {
        return em.createQuery("SELECT u FROM User AS u WHERE loginId = :loginId", User.class)
                    .setParameter("loginId", loginId)
                    .getResultList();
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User AS u", User.class)
                .getResultList();
    }

    public void update(User user) {

    }

}
