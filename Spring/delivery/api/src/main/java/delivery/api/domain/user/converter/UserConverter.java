package delivery.api.domain.user.converter;

import delivery.api.common.annotation.Converter;
import delivery.api.common.error.ErrorCode;
import delivery.api.common.exception.ApiException;
import delivery.api.domain.user.controller.model.UserRegisterRequest;
import delivery.api.domain.user.controller.model.UserResponse;
import delivery.db.user.UserEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Converter
@RequiredArgsConstructor
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request) {
        return Optional.ofNullable(request)
                .map(it -> {
                    return UserEntity.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .address(request.getAddress())
                            .build();
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "userRegisterRequest Null"));
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(it -> {
                    return UserResponse.builder()
                            .id(userEntity.getId())
                            .name(userEntity.getName())
                            .status(userEntity.getStatus())
                            .email(userEntity.getEmail())
                            .address(userEntity.getAddress())
                            .registerAt(userEntity.getRegisteredAt())
                            .unregisterAt(userEntity.getUnregisteredAt())
                            .lastLoginAt(userEntity.getLastLoginAt())
                            .build();
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "userRegisterRequest null"));
    }
}
