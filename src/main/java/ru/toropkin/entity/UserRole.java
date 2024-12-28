package ru.toropkin.entity;

public enum UserRole {
    ROLE_USER(1),
    ROLE_ADMIN(2);

    private int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
