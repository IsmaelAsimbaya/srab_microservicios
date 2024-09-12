package com.srab.horarios.db;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_horario;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiaHorario> diasHorario;

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

    public List<DiaHorario> getDiasHorario() {
        return diasHorario;
    }

    public void setDiasHorario(List<DiaHorario> diasHorario) {
        this.diasHorario = diasHorario;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id_horario=" + id_horario +
                ", nombre='" + nombre + '\'' +
                ", diasHorario=" + diasHorario +
                '}';
    }
}
