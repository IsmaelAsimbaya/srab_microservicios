package com.srab.usuarios.dtos;

import java.time.LocalDateTime;

public class LoginDto {

    private Integer id_login;
    private Integer id_usuario;
    private String username;
    private String password_hash;
    private String salt;
    private String roles;
    private LocalDateTime last_login;
    private Boolean is_active;

    public Integer getId_login() {
        return id_login;
    }

    public void setId_login(Integer id_login) {
        this.id_login = id_login;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "id_login=" + id_login +
                ", id_usuario=" + id_usuario +
                ", username='" + username + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", salt='" + salt + '\'' +
                ", roles='" + roles + '\'' +
                ", last_login=" + last_login +
                ", is_active=" + is_active +
                '}';
    }
}
