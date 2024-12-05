package delivery.api.domain.user.controller.model;

import delivery.db.user.enums.UserStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private UserStatus status;
    private String address;

    private LocalDateTime registerAt;
    private LocalDateTime unregisterAt;
    private LocalDateTime lastLoginAt;
}
