package com.product.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String postalCode;

    private String roadAddress;

    private String detailAddress;

    private boolean isPrimary;

    public Address(String postalCode, String roadAddress, String detailAddress) {
        this.postalCode = postalCode;
        this.roadAddress = roadAddress;
        this.detailAddress = detailAddress;
        this.isPrimary = true;
    }

    public String getAddress() {
        return roadAddress + postalCode;
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void addUser(User user) {
        this.user = user;
    }
}
