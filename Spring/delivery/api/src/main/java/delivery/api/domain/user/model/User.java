package delivery.api.domain.user.model;


import delivery.db.user.enums.UserStatus;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String name;
    private String password;
    private UserStatus status;
    private String address;

    private LocalDateTime registerAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime lastLoginAt;
}
