package com.product.domain.user.dto;

import com.product.domain.user.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RequestUserSave {

    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private MultipartFile profileImage;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String roadAddress;
    @NotBlank
    private String detailAddress;
}