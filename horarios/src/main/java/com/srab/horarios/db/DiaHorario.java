package com.srab.horarios.db;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "dia_horario")
public class DiaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dia_horario;

    @Column(name = "dia_semana", nullable = false)
    private String diaSemana;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    public Integer getId_dia_horario() {
        return id_dia_horario;
    }

    public void setId_dia_horario(Integer id_dia_horario) {
        this.id_dia_horario = id_dia_horario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "DiaHorario{" +
                "id_dia_horario=" + id_dia_horario +
                ", diaSemana='" + diaSemana + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", horario=" + horario +
                '}';
    }
}
