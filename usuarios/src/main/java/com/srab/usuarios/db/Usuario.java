package com.srab.usuarios.db;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "ci", nullable = false)
    private String ci;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "face_source_url", nullable = false)
    private String face_source_url;

    @Column(name = "telefono_movil")
    private String telefono_movil;

    @Column(name = "telefono_fijo")
    private String telefono_fijo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "id_lugar", nullable = false)
    private Integer id_lugar;

    @Column(name = "id_horario", nullable = false)
    private Integer id_horario;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFace_source_url() {
        return face_source_url;
    }

    public void setFace_source_url(String face_source_url) {
        this.face_source_url = face_source_url;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(Integer id_lugar) {
        this.id_lugar = id_lugar;
    }

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", ci='" + ci + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                ", face_source_url='" + face_source_url + '\'' +
                ", telefono_movil='" + telefono_movil + '\'' +
                ", telefono_fijo='" + telefono_fijo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id_lugar=" + id_lugar +
                ", id_horario=" + id_horario +
                '}';
    }
}
