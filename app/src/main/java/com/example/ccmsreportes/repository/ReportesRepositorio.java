package com.example.ccmsreportes.repository;

import com.example.ccmsreportes.database.ReportesDao;
import com.example.ccmsreportes.model.Reportes;
import java.util.List;

public class ReportesRepositorio implements ReportesDao {
    private ReportesDao dao;
    public ReportesRepositorio (ReportesDao reportesDao){
        this.dao = reportesDao;
    }

    @Override
    public List<Reportes> getAll(){
        return dao.getAll();
    }
    @Override
    public Reportes findById(int id_Reporte){
        return dao.findById(id_Reporte);
    }
    @Override
    public void insert (Reportes reportes){dao.insert(reportes);}

    @Override
    public void update (Reportes reportes){dao.update(reportes);}

    @Override
    public  void delete (Reportes reportes){dao.delete(reportes);}
}