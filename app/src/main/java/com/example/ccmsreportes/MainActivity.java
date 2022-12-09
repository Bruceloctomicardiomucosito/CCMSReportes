package com.example.ccmsreportes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ccmsreportes.api.LocalNetworkAPI;
import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.model.ResponseReporte;
import com.example.ccmsreportes.service.ServiceRetrofit;

import java.time.LocalDate;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText nombreUsusario, id_Dispositivo, descripcion;
    private Button guardadReporte, btnSiguiente;
    //////
    private Reportes reportes;
    private LocalNetworkAPI localNetworkAPI;
    //////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        db = AppDatabase.getInstance(this.getApplicationContext());
        ReportesDao reportesDao = db.reportesDao();
        ReportesRepositorio reportesRepositorio = new ReportesRepositorio(reportesDao);
        Reportes reportes = new Reportes();
        */
        //Botones
        guardadReporte = (Button) findViewById(R.id.btnRegistrar);
        btnSiguiente = (Button) findViewById(R.id.btnVerLista);

        ///EditText
        id_Dispositivo = (EditText) findViewById(R.id.txtNumeroDispositivo);
        descripcion = (EditText) findViewById(R.id.txtDescripcion);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });
        guardadReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportes = new Reportes();
                String i = id_Dispositivo.getText().toString();
                int id = Integer.parseInt(i);
                //reportes.setIdDevice(id);
                LocalDate fechaRegistro = LocalDate.now();
                //reportes.setFecha(fechaRegistro.toString());
                reportes.setDescripcion(descripcion.getText().toString());
                //reportes.setNombreProf("Calonsho Mora");
                //reportes.setIdProf(1);
                reportes.setRevisado(1);
                //reportesRepositorio.insert(reportes);
                Toast.makeText(MainActivity.this,"Reporte registrado correctamente...",Toast.LENGTH_SHORT).show();
                ////Supongo que aui se consume la api......................
                localNetworkAPI = ServiceRetrofit.getClient().create(LocalNetworkAPI.class);
                retrofit2.Call<ResponseReporte> call = localNetworkAPI.setReporte(reportes);
                call.enqueue(new Callback<ResponseReporte>(){
                    @Override
                    public void onResponse(retrofit2.Call<ResponseReporte> call, Response<ResponseReporte> response) {
                        if (response.isSuccessful())
                        {
                            Log.d("RespuestaBien",response.message());
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponseReporte> call, Throwable t) {
                        {
                            Log.d("RespuestaMal",t.getMessage());
                        }
                    }
                });
                /*
                String i = id_Dispositivo.getText().toString();
                int id = Integer.parseInt(i);
                LocalDate fechaRegistro = LocalDate.now();
                reportes.setIdDevice(id);
                reportes.setFecha(fechaRegistro.toString());
                reportes.setDescripcion(descripcion.getText().toString());
                reportes.setNombreProf("Calonsho Mora");
                reportes.setIdProf(1);
                reportes.setRevisado(1);
                reportesRepositorio.insert(reportes);
                Toast.makeText(MainActivity.this,"Reporte registrado correctamente..."+id,Toast.LENGTH_SHORT).show();
           */
            }
        });
/*
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPass.length() <= 0 || txtUsuario.length() <=0)
                {
                    Toast.makeText(getApplicationContext(),"Completa todos los campos por favor",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent i = new Intent(MainActivity.this, Reportes.class);
                    startActivity(i);
                }
            }
        });*/
    }
}