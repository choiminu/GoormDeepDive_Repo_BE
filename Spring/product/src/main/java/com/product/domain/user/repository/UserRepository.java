package com.product.domain.user.repository;

import com.product.domain.user.dto.RequestUserUpdate;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
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

    public Optional<User> findByLoginId(String loginId) {
        try {
            User user = em.createQuery("SELECT u FROM User AS u WHERE loginId = :loginId", User.class)
                    .setParameter("loginId", loginId)
                    .getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User AS u", User.class)
                .getResultList();
    }

    public void update(User user) {

    }

}
