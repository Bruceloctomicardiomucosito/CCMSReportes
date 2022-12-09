package com.example.ccmsreportes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsertReporte {

    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("nombreProfesor")
    @Expose
    private String nombreProfesor;
    @SerializedName("idProfesor")
    @Expose
    private Integer idProfesor;
    @SerializedName("idDispositivo")
    @Expose
    private Integer idDispositivo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InsertReporte withDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public InsertReporte withNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
        return this;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public InsertReporte withIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public InsertReporte withIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
        return this;
    }

}
