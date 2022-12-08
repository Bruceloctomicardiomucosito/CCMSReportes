package com.example.ccmsreportes.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Dao;

import com.example.ccmsreportes.model.Reportes;

import java.util.List;
@Dao

public interface ReportesDao {
    @Insert
    void insert (Reportes reportes);

    @Update
    void update (Reportes reportes);

    @Delete
    void delete (Reportes reportes);

    @Query("Select * from Tb_Reportes")
    List<Reportes> getAll();

    @Query("Select * from Tb_Reportes where id_Reporte = :id_Reporte")
    Reportes findById(int id_Reporte);
}
