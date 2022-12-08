package com.example.ccmsreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

///Librerias  de JSON
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

public class Login extends AppCompatActivity {

    private EditText usuario, contraseña;
    private Button btnIniciarSesion;
    String ip = "http://localhost";
    String loginphp = ip + "/login.php";

    ObtenerWebService hiloConexion;

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
                hiloConexion = new ObtenerWebService();
                String cadenallamada = loginphp + "?NombreUsuario="+usuario+"&contra="+contraseña;
                hiloConexion.execute(cadenallamada,"1"); ////Parametros que recibe el doInBackground;

                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();
                if (usuario.length() <= 0 || contraseña.length() <= 0)
                {
                    Toast.makeText(Login.this,"Complete todos los campos por favor",Toast.LENGTH_SHORT).show();
                }
                else {
                    ///Aqui va la cojdicion que validac si el usuario existe o no
                    if (user.equals("Alonso") && pass.equals("123")) {
                        Toast.makeText(Login.this,"Correcto",Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(Login.this, ListActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Usuario o cotraseña incorrectos",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}