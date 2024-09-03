package com.srab.logins.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotNull
    private Integer id_usuario;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String roles;

    @NotNull
    private Boolean is_active;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public @NotNull Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(@NotNull Boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "id_usuario=" + id_usuario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
