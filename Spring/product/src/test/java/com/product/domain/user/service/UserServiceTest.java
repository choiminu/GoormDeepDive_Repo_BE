package com.product.domain.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.domain.user.dto.UserLoginRequest;
import com.product.domain.user.dto.UserSignupRequest;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.Address;
import com.product.domain.user.model.User;
import com.product.domain.user.repository.UserRepository;
import com.product.utils.FileStore;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    FileStore fileStore;

    @InjectMocks
    UserService userService;

    @Test
    void 회원가입_성공() {
        //given
        UserSignupRequest userSignupRequest = createUserSignupRequest();
        User user = createUser();

        //when
        when(userRepository.save(any(User.class))).thenReturn(user);
        User savedUser = userService.signup(userSignupRequest);

        //then
        assertThat(savedUser.getLoginId()).isEqualTo(user.getLoginId());
        verify(userRepository).save(any(User.class));
    }


    @Test
    void 회원가입_실패() {
        //given
        UserSignupRequest userSignupRequest = createUserSignupRequest();

        //when
        when(userRepository.save(any(User.class))).thenThrow(DuplicateLoginIdException.class);

        //then
        Assertions.assertThatThrownBy(() -> userService.signup(userSignupRequest))
                .isInstanceOf(DuplicateLoginIdException.class);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void 로그인_성공_올바른_아이디와_비밀번호() {
        //given
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setLoginId("test");
        loginRequest.setPassword("1234");
        when(userRepository.findByLoginId(any(String.class))).thenReturn(Optional.of(createUser()));

        //when
        User user = userService.login(loginRequest);

        //then
        Assertions.assertThat(user.getLoginId()).isEqualTo("test");
        Assertions.assertThat(user.getPassword()).isEqualTo("1234");
        verify(userRepository).findByLoginId("test");
    }

    @Test
    void 로그인_실패_존재하지_않는_아이디() {
        // given
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setLoginId("test");
        loginRequest.setPassword("1234");
        when(userRepository.findByLoginId("nonexistent")).thenReturn(Optional.empty());

        // when & then
        User user = userService.login(loginRequest);

        Assertions.assertThat(user).isEqualTo(null);
    }

    private UserSignupRequest createUserSignupRequest() {
        UserSignupRequest request = new UserSignupRequest();
        request.setLoginId("testUser");
        request.setPassword("password123");
        request.setName("Test User");
        request.setEmail("testuser@gmail.com");
        request.setPostalCode("12345");
        request.setRoadAddress("Test Street");
        request.setDetailAddress("Test Apartment");
        return request;
    }

    private User createUser() {
        return new User("test", "1234", "name", "email@gmail.com", null, new Address());
    }
}