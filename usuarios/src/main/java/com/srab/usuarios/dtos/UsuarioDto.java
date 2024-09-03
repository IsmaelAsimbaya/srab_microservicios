package com.srab.usuarios.dtos;

import java.time.LocalDate;
import java.util.List;

public class UsuarioDto {

    private Integer id_usuario;
    private String ci;
    private LoginDto login;
    private String nombres;
    private String apellidos;
    private LocalDate fecha_nacimiento;
    private String email;
    private String face_source_url;
    private String telefono_movil;
    private String telefono_fijo;
    private String direccion;
    private Integer id_lugar;
    private LugarTrabajoDto lugarTrabajo;
    private Integer id_horario;
    private HorarioDto horario;
    private List<MarcacionDto> marcaciones;

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

    public LoginDto getLogin() {
        return login;
    }

    public void setLogin(LoginDto login) {
        this.login = login;
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

    public LugarTrabajoDto getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(LugarTrabajoDto lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public HorarioDto getHorario() {
        return horario;
    }

    public void setHorario(HorarioDto horario) {
        this.horario = horario;
    }

    public List<MarcacionDto> getMarcaciones() {
        return marcaciones;
    }

    public void setMarcaciones(List<MarcacionDto> marcaciones) {
        this.marcaciones = marcaciones;
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
        return "UsuarioDto{" +
                "id_usuario=" + id_usuario +
                ", ci='" + ci + '\'' +
                ", login=" + login +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", email='" + email + '\'' +
                ", face_source_url='" + face_source_url + '\'' +
                ", telefono_movil='" + telefono_movil + '\'' +
                ", telefono_fijo='" + telefono_fijo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id_lugar=" + id_lugar +
                ", lugarTrabajo=" + lugarTrabajo +
                ", id_horario=" + id_horario +
                ", horario=" + horario +
                ", marcaciones=" + marcaciones +
                '}';
    }
}
