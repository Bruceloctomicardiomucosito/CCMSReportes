package com.example.ccmsreportes.model.Usuario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profesor {
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Apellidos")
    @Expose
    private String apellidos;
    @SerializedName("idPorfe")
    @Expose
    private Integer idPorfe;
    @SerializedName("Username")
    @Expose
    private String username;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Profesor withApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Integer getIdPorfe() {
        return idPorfe;
    }

    public void setIdPorfe(Integer idPorfe) {
        this.idPorfe = idPorfe;
    }

    public Profesor withIdPorfe(Integer idPorfe) {
        this.idPorfe = idPorfe;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profesor withUsername(String username) {
        this.username = username;
        return this;
    }
}