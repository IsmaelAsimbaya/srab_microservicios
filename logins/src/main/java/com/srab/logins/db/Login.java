package com.srab.logins.db;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_login;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String password_hash;

    @Column(name = "salt")
    private String salt;

    @Column(name = "roles")
    private String roles;

    @Column(name = "last_login")
    private LocalDateTime last_login;

    @Column(name = "is_active", nullable = false)
    private Boolean is_active = false;

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

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        return "Login{" +
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
