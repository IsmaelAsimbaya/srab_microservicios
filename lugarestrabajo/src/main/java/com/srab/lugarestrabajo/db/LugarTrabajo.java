package com.srab.lugarestrabajo.db;

import jakarta.persistence.*;

@Entity
@Table(name = "lugartrabajo")
public class LugarTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_lugar;

    @Column(name = "nombre_lugar", nullable = false)
    private String nombreLugar;

    @Column(name = "direccion_lugar", nullable = false)
    private String direccionLugar;

    @Column(name = "cord", nullable = false)
    private String cord;

    @Column(name = "axis1", nullable = false)
    private String axis1;

    @Column(name = "axis2", nullable = false)
    private String axis2;

    @Column(name = "axis3", nullable = false)
    private String axis3;

    @Column(name = "axis4", nullable = false)
    private String axis4;

    public Integer getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(Integer id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getDireccionLugar() {
        return direccionLugar;
    }

    public void setDireccionLugar(String direccionLugar) {
        this.direccionLugar = direccionLugar;
    }

    public String getCord() {
        return cord;
    }

    public void setCord(String cord) {
        this.cord = cord;
    }

    public String getAxis1() {
        return axis1;
    }

    public void setAxis1(String axis1) {
        this.axis1 = axis1;
    }

    public String getAxis2() {
        return axis2;
    }

    public void setAxis2(String axis2) {
        this.axis2 = axis2;
    }

    public String getAxis3() {
        return axis3;
    }

    public void setAxis3(String axis3) {
        this.axis3 = axis3;
    }

    public String getAxis4() {
        return axis4;
    }

    public void setAxis4(String axis4) {
        this.axis4 = axis4;
    }

    @Override
    public String toString() {
        return "LugarTrabajo{" +
                "id_lugar=" + id_lugar +
                ", nombreLugar='" + nombreLugar + '\'' +
                ", direccionLugar='" + direccionLugar + '\'' +
                ", cord='" + cord + '\'' +
                ", axis1='" + axis1 + '\'' +
                ", axis2='" + axis2 + '\'' +
                ", axis3='" + axis3 + '\'' +
                ", axis4='" + axis4 + '\'' +
                '}';
    }
}
