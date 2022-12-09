package com.example.ccmsreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

///Librerias  de JSON
import com.example.ccmsreportes.api.LocalNetworkAPI;
import com.example.ccmsreportes.model.InsertReporte;
import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.model.ResponseReporte;
import com.example.ccmsreportes.model.Usuario.LoginProfesor;
import com.example.ccmsreportes.model.Usuario.Profesor;
import com.example.ccmsreportes.model.Usuario.ProfesorResponse;
import com.example.ccmsreportes.service.ServiceRetrofit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText usuario, contraseña;
    private Button btnIniciarSesion;

    private LoginProfesor logProf;
    private Profesor proflogged;
    private ProfesorResponse resProfe;

    private LocalNetworkAPI localNetworkAPI;


    //ObtenerWebService hiloConexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.txtUsuario);
        contraseña = (EditText) findViewById(R.id.txtPassword);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logProf = new LoginProfesor();
                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();

                logProf.setUser(user);
                logProf.setPass(pass);
//                ReporteIn.setIdProfesor(1);
//                ReporteIn.setNombreProfesor("cesar");
//                ReporteIn.setIdDispositivo(id);

                localNetworkAPI = ServiceRetrofit.getListReportes().create(LocalNetworkAPI.class);
                retrofit2.Call<ProfesorResponse> call = localNetworkAPI.loginFun(logProf);

                call.enqueue(new Callback<ProfesorResponse>() {
                    @Override
                    public void onResponse(Call<ProfesorResponse> call, Response<ProfesorResponse> response) {
                        proflogged = new Profesor();
                        proflogged = response.body().getProfesor();
                        Toast.makeText(Login.this,response.body().getProfesor().getNombre(),Toast.LENGTH_SHORT).show();
                        Log.i("ubicacion",response.body().getProfesor().getNombre());
                        if (usuario.length() <= 0 || contraseña.length() <= 0)
                        {
                            Toast.makeText(Login.this,"Complete todos los campos por favor",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            ///Aqui va la cojdicion que validac si el usuario existe o no
                            if (response.body().getResultado() == 1) {
                                Toast.makeText(Login.this,"Correcto",Toast.LENGTH_SHORT).show();
                                Intent i= new Intent(Login.this, ListActivity.class);
                                Bundle mBundle = new Bundle();
                                mBundle.putString("NameProf", proflogged.getNombre());
                                mBundle.putString("ApeProf", proflogged.getApellidos());
                                mBundle.putString("ifProfLogged", proflogged.getUsername());
                                i.putExtras(mBundle);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(Login.this,"Usuario o cotraseña incorrectos",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ProfesorResponse> call, Throwable t) {
                        Log.i("ubicacion","asssssss");
                        Toast.makeText(Login.this,"a",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}