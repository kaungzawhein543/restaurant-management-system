package com.mm.zwel.application.constants;

import java.util.List;

public enum UserRole {
    SUPER_ADMIN, ADMIN, USER;

    public static List<UserRole> availableValues() {
        return List.of(ADMIN, USER);
    }
}
