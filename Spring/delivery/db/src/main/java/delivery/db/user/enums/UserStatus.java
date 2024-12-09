package delivery.db.user.enums;

public enum UserStatus {
    REGISTER("등록"), UNREGISTER("해지");

    private final String description;

    UserStatus(String description) {
        this.description = description;
    }
}
