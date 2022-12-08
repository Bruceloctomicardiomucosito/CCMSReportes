package com.example.ccmsreportes.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "Tb_Reportes")

public class Reportes implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id_Reporte")
    private int id_Reporte;

    @ColumnInfo(name = "Fecha")
    private String fecha;

    @ColumnInfo(name = "Descripcion")
    private String descripcion;

    @ColumnInfo(name = "NombreProf")
    private String nombreProf;

    @ColumnInfo (name = "IdProf")
    private int idProf;

    @ColumnInfo (name = "IdDispositivo")
    private int idDevice;

    @ColumnInfo (name = "Revisado")
    private int revisado;

    public Reportes(){}

    public Reportes(int id_Reporte, String fecha, String descripcion, String nombreProf, int idProf, int idDevice, int revisado) {
        this.id_Reporte = id_Reporte;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombreProf = nombreProf;
        this.idProf = idProf;
        this.idDevice = idDevice;
        this.revisado = revisado;
    }

    public int getId_Reporte() {
        return id_Reporte;
    }

    public void setId_Reporte(int id_Reporte) {
        this.id_Reporte = id_Reporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public int getRevisado() {
        return revisado;
    }

    public void setRevisado(int revisado) {
        this.revisado = revisado;
    }
}
