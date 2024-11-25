package com.product.domain.user.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String loginId;

    private String password;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    private LocalDateTime createAt;

    private LocalDateTime last_login;

    private String profileURL;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.addUser(this);
    }

}
