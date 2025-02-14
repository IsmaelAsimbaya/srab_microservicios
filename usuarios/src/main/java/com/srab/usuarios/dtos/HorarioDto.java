package com.srab.usuarios.dtos;

import java.util.List;

public class HorarioDto {

    private Integer id_horario;
    private String nombre;
    private List<DiaHorarioDto> diasHorario;

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DiaHorarioDto> getDiasHorario() {
        return diasHorario;
    }

    public void setDiasHorario(List<DiaHorarioDto> diasHorario) {
        this.diasHorario = diasHorario;
    }

    @Override
    public String toString() {
        return "HorarioDto{" +
                "id_horario=" + id_horario +
                ", nombre='" + nombre + '\'' +
                ", diasHorario=" + diasHorario +
                '}';
    }
}
