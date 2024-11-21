package com.dbexplorer.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@Getter @Setter
public class MemberCreateRequest {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
}
