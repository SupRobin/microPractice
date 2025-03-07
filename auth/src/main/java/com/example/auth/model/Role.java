package com.example.auth.model;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_GUEST("Guest"),
    ROLE_USER("Standard User"),
    ROLE_ADMIN("Administrator");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}
