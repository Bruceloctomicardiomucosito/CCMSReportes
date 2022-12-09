package com.example.ccmsreportes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultReportes {
    @SerializedName("Reporte")
    @Expose
    private List<Reportes> reporte = null;

    public List<Reportes> getReporte() {
        return reporte;
    }

    public void setReporte(List<Reportes> reporte) {
        this.reporte = reporte;
    }
}
