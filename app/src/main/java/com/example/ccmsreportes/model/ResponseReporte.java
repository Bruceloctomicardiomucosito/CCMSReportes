package com.example.ccmsreportes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ResponseReporte {
    @SerializedName("reporte")
    @Expose
    private Reportes reportes;

    @SerializedName("status")
    @Expose
    private int status_server;

    @SerializedName("msj")
    @Expose
    private String mensaje;
}
