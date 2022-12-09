package com.example.ccmsreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.viewmodel.ListaReporteViewModel;

public class UpdDelActivity extends AppCompatActivity{
    private TextView txtDescripcion, txtStatus, txtFechaRegistro;
    private TextView lblId;
    private Button btnEditar,btnEliminar, btnRegresar;
    private Reportes reportes;
    private ListaReporteViewModel reportesViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_del);

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
        lblId=(TextView) findViewById(R.id.label_iDReporte);

        lblId.setText("Numero de reporte: "+String.valueOf(reportes.getId_Reporte()));
        txtDescripcion.setText(reportes.getDescripcion());
        int estado = reportes.getRevisado();
        mostrarEstado(estado);
        //txtFechaRegistro.setText("Fecha de registro: "+reportes.getFecha());
        txtFechaRegistro.setText("Fecha de registro: Aqui se concatena la fecha");
        //txtStatus.setText(reportes.getRevisado());
        /*
        //txtApMaterno.setText(persona.getApMaterno());

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportesRepositorio.update(reportes);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportesRepositorio.delete(reportes);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UpdDelActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });*/
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
