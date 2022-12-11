package com.example.ccmsreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.ccmsreportes.api.LocalNetworkAPI;
import com.example.ccmsreportes.model.DetallesReporte;
import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.service.ServiceRetrofit;
import com.example.ccmsreportes.viewmodel.ListaReporteViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdDelActivity extends AppCompatActivity{
    private TextView txtDescripcion, txtStatus, txtFechaRegistro, txtDispositivo;
    private Button btnEditar,btnEliminar, btnRegresar;
    private Reportes reportes;
    private ListaReporteViewModel reportesViewModel ;

    private DetallesReporte detalles;
    private LocalNetworkAPI localNetworkAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_del);

        Bundle resultIntent = getIntent().getExtras();
        int idReporte = resultIntent.getInt("Reporte");

        Log.i("Paulino dice",String.valueOf(idReporte));

        //Botones
        /*
        btnEditar=(Button) findViewById(R.id.btnEditar);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);
        btnRegresar=(Button)findViewById(R.id.btnregresar) ;
        */
        //TextViews
        txtDescripcion=(TextView)findViewById(R.id.lblDescripcion);
        txtStatus=(TextView)findViewById(R.id.lblEstado);
        txtFechaRegistro=(TextView) findViewById(R.id.lblFechaRegistro);
        //txtApMaterno=(EditText)findViewById(R.id.txtapmaternoud);
        //label
        txtDispositivo=(TextView) findViewById(R.id.txtDispositvoInfo);

        localNetworkAPI = ServiceRetrofit.getListaReportes().create(LocalNetworkAPI.class);

        retrofit2.Call<DetallesReporte> call = localNetworkAPI.getDetalleReporte(idReporte);

        call.enqueue(new Callback<DetallesReporte>() {
            @Override
            public void onResponse(Call<DetallesReporte> call, Response<DetallesReporte> response) {
                Log.i("testtest","Test TEst");

                Log.i("ubicacion",response.body().toString());
                txtDispositivo.setText("Dispositivo Afectado: "+response.body().getDispositivo());
                txtDescripcion.setText("Descripcion de la Falla: "+response.body().getDescDet());
                txtFechaRegistro.setText("Fecha de registro: "+response.body().getFecha());
                int estado = response.body().getRev();
                mostrarEstado(estado);

            }

            @Override
            public void onFailure(Call<DetallesReporte> call, Throwable t) {
                Log.i("testtest2","Test TEsEEt");

            }
        });


//        lblId.setText("Numero de reporte: "+String.valueOf(reportes.getIdReporte()));
//        txtDescripcion.setText(reportes.getDescripcion());
//        int estado = reportes.getRevisado();
//        mostrarEstado(estado);
//        //txtFechaRegistro.setText("Fecha de registro: "+reportes.getFecha());
//        txtFechaRegistro.setText("Fecha de registro: Aqui se concatena la fecha");
//        //txtStatus.setText(reportes.getRevisado());
//        /*
//        //txtApMaterno.setText(persona.getApMaterno());
//
//        btnEditar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                reportesRepositorio.update(reportes);
//            }
//        });
//
//        btnEliminar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                reportesRepositorio.delete(reportes);
//            }
//        });
//
//        btnRegresar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(UpdDelActivity.this, ListActivity.class);
//                startActivity(intent);
//            }
//        });*/
    }
    private void mostrarEstado(int e)
    {
        if (e == 0)
        {
            txtStatus.setText("Revisión Pendiente");
        }
        if (e == 1)
        {
            txtStatus.setText("En proceso");
        }
        if (e == 3)
        {
            txtStatus.setText("¡¡Completado!!");
        }
    }
}