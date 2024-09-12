package com.srab.horarios.dtos;

import java.util.List;

public class HorarioDTO {
    private Integer id_horario;
    private String nombre;
    private List<DiaHorarioDTO> diasHorario;

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

    public List<DiaHorarioDTO> getDiasHorario() {
        return diasHorario;
    }

    public void setDiasHorario(List<DiaHorarioDTO> diasHorario) {
        this.diasHorario = diasHorario;
    }

    @Override
    public String toString() {
        return "HorarioDTO{" +
                "id_horario=" + id_horario +
                ", nombre='" + nombre + '\'' +
                ", diasHorario=" + diasHorario +
                '}';
    }
}
