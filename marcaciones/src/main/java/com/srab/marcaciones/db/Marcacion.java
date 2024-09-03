package com.srab.marcaciones.db;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "marcacion")
public class Marcacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marcacion;

    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "image_source", columnDefinition = "TEXT")
    private String image_source;

    public Integer getId_marcacion() {
        return id_marcacion;
    }

    public void setId_marcacion(Integer id_marcacion) {
        this.id_marcacion = id_marcacion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    @Override
    public String toString() {
        return "Marcacion{" +
                "id_marcacion=" + id_marcacion +
                ", id_usuario=" + id_usuario +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", image_source='" + image_source + '\'' +
                '}';
    }
}
