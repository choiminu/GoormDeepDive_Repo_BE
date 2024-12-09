package delivery.api.domain.user.business;

import delivery.api.common.annotation.Business;
import delivery.api.domain.user.controller.model.UserRegisterRequest;
import delivery.api.domain.user.controller.model.UserResponse;
import delivery.api.domain.user.converter.UserConverter;
import delivery.api.domain.user.service.UserService;
import delivery.db.user.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class UserBusiness {

    private final UserService userService;
    private final UserConverter userConverter;
//    private TokenBusiness tokenBusiness;

    public UserResponse register(@Valid UserRegisterRequest request) {
        UserEntity entity = userConverter.toEntity(request);
        UserEntity newEntity = userService.register(entity);
        UserResponse response = userConverter.toResponse(newEntity);
        return response;
    }

//    public TokenResponse login(@Valid UserLoginRequest request) {
//        UserEntity userEntity = userService.login(request.getEmail(), request.getPassword());
//
//        // 사용자 없으면 Throw
//
//        // 토큰생성
//
//    }

    public UserResponse me(Long userId) {
        UserEntity userEntity = userService.getUserWithThrow(userId);
        return userConverter.toResponse(userEntity);
    }

}
