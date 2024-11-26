package com.product.domain.user.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String loginId;

    private String password;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    private LocalDateTime createAt;

    private LocalDateTime last_login;

    private String profileURL;

    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String loginId, String password, String name, String email, String profileURL, Address address) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.createAt = LocalDateTime.now();
        this.last_login = LocalDateTime.now();
        this.profileURL = profileURL;
        this.role = Role.USER;
        addAddress(address);
    }

    public void editUserInfo(String password, String email, String name) {
        if (password != null) {
            this.password = password;
        }

        if (email != null) {
            this.email = email;
        }

        if (name != null) {
            this.name = name;
        }
    }

    public Address getAddress() {
        for (Address address : addresses) {
            if (address.isPrimary()) {
                return address;
            }
        }
        return null;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.addUser(this);
    }

}
