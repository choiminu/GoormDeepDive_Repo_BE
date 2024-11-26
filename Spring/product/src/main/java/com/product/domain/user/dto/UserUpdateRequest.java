package com.product.domain.user.dto;

import com.product.domain.user.model.Address;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private String password;
    private String nam;
    private String email;
    private String profileURL;
    private Address address;
}
