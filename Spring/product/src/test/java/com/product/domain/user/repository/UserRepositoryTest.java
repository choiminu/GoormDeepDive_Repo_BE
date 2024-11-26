package com.product.domain.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.Address;
import com.product.domain.user.model.Role;
import com.product.domain.user.model.User;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Import({UserRepository.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 회원가입_성공() {
        // given
        User user = createUser("hello");

        // when
        User savedUser = userRepository.save(user);

        // then
        verifyUser(savedUser, "hello", "test", "1234", "admin@gmail.com", Role.USER);
    }

    @Test
    void 회원가입_실패_중복된_아이디() {
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
    void 회원ID_회원조회() {
        // given
        User user = createUser("hello");
        userRepository.save(user);

        // when
        Optional<User> foundUser = userRepository.findById(user.getId());

        // then
        assertThat(foundUser).isPresent();
        verifyUser(foundUser.get(), "hello", "test", "1234", "admin@gmail.com", Role.USER);
    }

    @Test
    void 로그인ID_회원조회() {
        // given
        User user = createUser("hello");
        userRepository.save(user);

        // when
        Optional<User> foundUser = userRepository.findByLoginId(user.getLoginId());

        // then
        assertThat(foundUser).isPresent();
        verifyUser(foundUser.get(), "hello", "test", "1234", "admin@gmail.com", Role.USER);
    }

    @Test
    void 로그인ID_회원조회_실패() {
        // given
        User user = createUser("hello");
        userRepository.save(user);

        // when
        Optional<User> foundUser = userRepository.findByLoginId("1234");

        // then
        assertThat(foundUser).isEmpty();
    }

    @Test
    void 모든_회원조회() {
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

    @Test
    void 회원정보_수정() {
        //given
        User user = createUser("hello");
        userRepository.save(user);

        //when
        User updateDto = new User(user.getLoginId(), "1234", "테스터", "hdtv@kakao.com", "null", new Address("123", "123", "123"));
        userRepository.update(user.getId(), updateDto);

        //then
        verifyUser(user, "hello", "테스터", "1234", "hdtv@kakao.com", Role.USER);
    }

    @Test
    void 회원정보_삭제() {
        //given
        User user = createUser("hello");
        userRepository.save(user);

        //when
        userRepository.delete(user);

        //then
        Optional<User> foundUser = userRepository.findById(user.getId());
        assertThat(foundUser.isEmpty()).isEqualTo(true);
    }

    private User createUser(String loginId) {
        return new User(loginId,
                "1234",
                "test",
                "admin@gmail.com",
                "abc.png",
                new Address("123",
                        "123",
                        "444"));
    }

    private void verifyUser(User user, String loginId, String name, String password, String email, Role role) {
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getLoginId()).isEqualTo(loginId);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getRole()).isEqualTo(role);
    }
}
