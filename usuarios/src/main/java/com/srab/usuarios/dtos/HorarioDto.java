package com.srab.usuarios.dtos;

import java.time.LocalTime;

public class HorarioDto {

    private Integer id_horario;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String diasSemana;
    private String nombre;

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "HorarioDto{" +
                "id_horario=" + id_horario +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", diasSemana='" + diasSemana + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
