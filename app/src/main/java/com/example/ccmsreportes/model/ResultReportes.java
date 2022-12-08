package com.example.ccmsreportes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultReportes {
    @SerializedName("results")
    @Expose
    private List<Reportes> results;

    public List<Reportes> getResults(){return results;}

    public void setResults(List<Reportes> results){ this.results = results;}
}
