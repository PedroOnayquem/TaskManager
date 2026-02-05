package com.onayquem.taskmanager.dto.auth;

public record AuthResponse(
    String token,
    String type,
    Long id,
    String name,
    String email,
    String role
) {
    public AuthResponse(String token, Long id, String name, String email, String role) {
        this(token, "Bearer", id, name, email, role);
    }
}
