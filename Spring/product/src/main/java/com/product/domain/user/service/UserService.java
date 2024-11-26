package com.product.domain.user.service;

import com.product.domain.user.dto.UserLoginRequest;
import com.product.domain.user.dto.UserSignupRequest;
import com.product.domain.user.exception.DuplicateLoginIdException;
import com.product.domain.user.model.Address;
import com.product.domain.user.model.User;
import com.product.domain.user.repository.UserRepository;
import com.product.utils.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final FileStore fileStore;

    public User signup(UserSignupRequest requestUser) {
        String profileUrl = fileStore.uploadFile(requestUser.getProfileImage());
        Address address = createAddress(requestUser);
        User user = createUser(requestUser, profileUrl, address);
        return userRepository.save(user);
    }


    private Address createAddress(UserSignupRequest requestUser) {
        return new Address(
                requestUser.getPostalCode(),
                requestUser.getRoadAddress(),
                requestUser.getDetailAddress()
        );
    }

    private User createUser(UserSignupRequest requestUser, String profileUrl, Address address) {
        return new User(requestUser.getLoginId(), requestUser.getPassword(), requestUser.getName(),
                requestUser.getEmail(), profileUrl, address);
    }

    public User login(UserLoginRequest userLoginRequest) {
        return userRepository.findByLoginId(userLoginRequest.getLoginId())
                .filter(user -> user.getPassword().equals(userLoginRequest.getPassword()))
                .orElse(null);
    }
}
