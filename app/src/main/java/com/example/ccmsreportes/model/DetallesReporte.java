package com.example.ccmsreportes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetallesReporte {
    @SerializedName("Fecha")
    @Expose
    private String fecha;
    @SerializedName("DescDet")
    @Expose
    private String descDet;
    @SerializedName("Dispositivo")
    @Expose
    private String dispositivo;
    @SerializedName("Rev")
    @Expose
    private Integer rev;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public DetallesReporte withFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getDescDet() {
        return descDet;
    }

    public void setDescDet(String descDet) {
        this.descDet = descDet;
    }

    public DetallesReporte withDescDet(String descDet) {
        this.descDet = descDet;
        return this;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public DetallesReporte withDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
        return this;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public DetallesReporte withRev(Integer rev) {
        this.rev = rev;
        return this;
    }
}