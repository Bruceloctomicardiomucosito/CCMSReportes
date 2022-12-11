package com.example.ccmsreportes.model.Usuario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfesorResponse {
    @SerializedName("resultado")
    @Expose
    private Integer resultado;
    @SerializedName("Profesor")
    @Expose
    private Profesor profesor;

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public ProfesorResponse withResultado(Integer resultado) {
        this.resultado = resultado;
        return this;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ProfesorResponse withProfesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }
}