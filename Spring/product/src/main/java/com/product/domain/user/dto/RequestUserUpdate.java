package com.product.domain.user.dto;

import com.product.domain.user.model.Address;
import lombok.Data;

@Data
public class RequestUserUpdate {
    private String password;
    private String nam;
    private String email;
    private String profileURL;
    private Address address;
}
