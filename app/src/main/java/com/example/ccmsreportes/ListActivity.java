package com.example.ccmsreportes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ccmsreportes.adapter.ReporteListAdapter;
import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.model.ResultReportes;
import com.example.ccmsreportes.viewmodel.ListaReporteViewModel;
import com.example.ccmsreportes.database.AppDatabase;
import com.example.ccmsreportes.database.ReportesDao;
import com.example.ccmsreportes.repository.ReportesRepositorio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
public class ListActivity extends AppCompatActivity implements ReporteListAdapter.ElementClickListener {

    private ListaReporteViewModel listaReporteViewModel;
    private ResultReportes resultReportes;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ReporteListAdapter reporteListAdapter;
    private FloatingActionButton  btnNewReporte;
    /*
    private List<Reportes> reportes;
    private LiveData<ResultReportes> reportesLiveData;
    ///private List<Reportes>  resultReportes;
    private AppDatabase db;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //btnNewReporte = (Button) findViewById(R.id.btnNewReporte);
        btnNewReporte = (FloatingActionButton) findViewById(R.id.btnNewReporte);

        recyclerView = (RecyclerView) findViewById(R.id.lista_reportes);
        linearLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(linearLayoutManager);

        ////Lineas de codigo de la anterior version local sin API
        ///db=AppDatabase.getInstance(this.getApplicationContext());
        ///ReportesDao reportesDao=db.reportesDao();
        ///ReportesRepositorio reportesRepositorio= new ReportesRepositorio(reportesDao);

        listaReporteViewModel = new ViewModelProvider(this).get(ListaReporteViewModel.class);
        resultReportes = new ResultReportes();
        listaReporteViewModel.CallServiceGetReporte(1);
        reporteListAdapter = new ReporteListAdapter(this,resultReportes.getResults(),this);
        recyclerView.setAdapter(reporteListAdapter);
        ////Esta linea fue modificada
        ///listaReporteViewModel.setReporte(List<ResultReportes>.getAll());
        ///////////////////Aqui me quedé
        //listaReporteViewModel.setReporte(resultReportes.getResults());
        ///reporteListAdapter = new ReporteListAdapter(this,reportes,this);
        ///recyclerView.setAdapter(reporteListAdapter);
        final Observer<ResultReportes> observer = new Observer<ResultReportes>() {
            @Override
            public void onChanged(ResultReportes reportesList) {
                if(reportesList !=null) {
                    resultReportes = reportesList;
                    reporteListAdapter.setReportesList(resultReportes.getResults());
                }
            }
        };
        listaReporteViewModel.getReportes().observe(this,observer);

        ///7Evento que se dispara a la hora de presionar el boton de nuevo reporte
        btnNewReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onElementClick(Reportes reportes) {
        //  Toast.makeText(this, persona.getNombre().toString() + " " + persona.getApPaterno().toString(),
        //        Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBtnElementClick(Reportes reportes) {
        //Toast.makeText(this, persona.getNombre().toString() + " " + persona.getApPaterno().toString(),
        //      Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ListActivity.this, UpdDelActivity.class);
        intent.putExtra("Reporte",reportes);
        startActivity(intent);
    }
}