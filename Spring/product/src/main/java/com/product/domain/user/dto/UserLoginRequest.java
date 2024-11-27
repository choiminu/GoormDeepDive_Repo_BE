package com.product.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginRequest {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
}
