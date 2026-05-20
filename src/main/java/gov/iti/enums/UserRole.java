package gov.iti.enums;

public enum UserRole {
    ADMIN,
    USER;

    public static final UserRole DEFAULT = USER;
    @Override
    public String toString() {
        return name();
    }
}
