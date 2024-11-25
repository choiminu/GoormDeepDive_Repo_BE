package com.product.domain.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.Role;
import com.product.domain.user.model.User;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("회원 저장이 성공적으로 이루어진다")
    void 회원_저장_성공() {
        // given
        User user = createUser();

        // when
        User savedUser = userRepository.save(user);

        // then
        verifyUser(savedUser, "hello", "최민우", "1234", "alsdn4590@gmail.com", Role.USER);
    }

    @Test
    @DisplayName("중복된 회원 아이디로 인해 저장이 실패한다")
    void 회원_저장_실패_중복_아이디() {
        // given
        User user1 = createUser("hello");
        User user2 = createUser("hello");

        // when
        userRepository.save(user1);

        // then
        Assertions.assertThatThrownBy(() -> userRepository.save(user2))
                .isInstanceOf(DuplicateLoginIdException.class);
    }

    @Test
    @DisplayName("회원 번호로 회원을 조회할 수 있다")
    void 회원_번호로_조회_성공() {
        // given
        User user = createUser();
        userRepository.save(user);
        entityManager.flush();

        // when
        Optional<User> foundUser = userRepository.findById(user.getId());

        // then
        assertThat(foundUser).isPresent();
        verifyUser(foundUser.get(), "hello", "최민우", "1234", "alsdn4590@gmail.com", Role.USER);
    }

    @Test
    @DisplayName("회원 아이디로 회원을 조회할 수 있다")
    void 회원_아이디로_조회_성공() {
        // given
        User user = createUser();
        userRepository.save(user);
        entityManager.flush();

        // when
        Optional<User> foundUser = userRepository.findByLoginId(user.getLoginId());

        // then
        assertThat(foundUser).isPresent();
        verifyUser(foundUser.get(), "hello", "최민우", "1234", "alsdn4590@gmail.com", Role.USER);
    }

    @Test
    @DisplayName("모든 회원을 조회할 수 있다")
    void 회원_전체_조회_성공() {
        // given
        User user1 = createUser("hello");
        User user2 = createUser("world");
        userRepository.save(user1);
        userRepository.save(user2);

        // when
        List<User> allUsers = userRepository.findAll();

        // then
        assertThat(allUsers.size()).isEqualTo(2);
        assertThat(allUsers).contains(user1, user2);
    }


    private User createUser() {
        return createUser("hello");
    }

    private User createUser(String loginId) {
        return User.builder()
                .id(null)
                .loginId(loginId)
                .password("1234")
                .name("최민우")
                .email("alsdn4590@gmail.com")
                .profileURL(null)
                .role(Role.USER)
                .addresses(null)
                .build();
    }

    private void verifyUser(User user, String loginId, String name, String password, String email, Role role) {
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getLoginId()).isEqualTo(loginId);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getRole()).isEqualTo(role);
        assertThat(user.getProfileURL()).isNull();
        assertThat(user.getAddresses()).isNull();
    }
}
