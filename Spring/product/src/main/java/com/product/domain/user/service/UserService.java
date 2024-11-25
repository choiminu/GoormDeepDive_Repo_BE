package com.product.domain.user.service;

import com.product.domain.user.dto.RequestUserSave;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.Address;
import com.product.domain.user.model.Role;
import com.product.domain.user.model.User;
import com.product.domain.user.repository.UserRepository;
import com.product.utils.FileStore;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final FileStore fileStore;

    public User join(RequestUserSave requestUser) {
        validateDuplicateLoginId(requestUser.getLoginId());
        String profileUrl = fileStore.uploadFile(requestUser.getProfileImage());
        Address address = createAddress(requestUser);
        User user = createUser(requestUser, profileUrl, address);
        return userRepository.save(user);
    }

    private void validateDuplicateLoginId(String loginId) {
        if (!userRepository.findByLoginId(loginId).isEmpty()) {
            throw new DuplicateLoginIdException(loginId + "는 이미 사용중입니다.");
        }
    }

    private Address createAddress(RequestUserSave requestUser) {
        return new Address(
                requestUser.getPostalCode(),
                requestUser.getRoadAddress(),
                requestUser.getDetailAddress()
        );
    }

    private User createUser(RequestUserSave requestUser, String profileUrl, Address address) {
        return User.builder()
                .loginId(requestUser.getLoginId())
                .password(requestUser.getPassword())
                .name(requestUser.getName())
                .email(requestUser.getEmail())
                .profileURL(profileUrl)
                .role(Role.USER)
                .addresses(List.of(address))
                .createAt(LocalDateTime.now())
                .last_login(LocalDateTime.now())
                .build();
    }
}
