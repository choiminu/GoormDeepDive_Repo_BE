package com.board.myboard.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LoginRequest {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
