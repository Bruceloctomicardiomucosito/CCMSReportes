package com.example.ccmsreportes;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ObtenerWebService extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params){
        URL url = null; //Url de donde queremos obtener la informacion
        String devuelve = "";

        if (params[1] == "1"){ ///Consulta por id
            try{
                String cadena = params[0];
                url = new URL(cadena);
                HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();//Abrir la conexion
                connection.setRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 1.5; es-ES EjemploHTTP)");

                int respuesta = connection.getResponseCode();
                StringBuilder result = new StringBuilder();

                if (respuesta == HttpsURLConnection.HTTP_OK)
                {
                    ///Prepara la cadena de entrada
                    InputStream in = new BufferedInputStream(connection.getInputStream());
                    //Se introduce en un BufferedReader
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    //Aqui se hace el proceso para que el JSONobject necesita un String  y se teine
                    //que transformar el BufferedReader a String... Esto se hace a travez de un StringBuilder

                    String line;
                    while ((line = reader.readLine()) != null){
                        result.append(line); ///Pasa por toda la entrada al StringBuilder
                    }
                    ///Creamos un objeto JSONobjet para poder acceder a los atributos (campos) del objeto
                    JSONObject respuestaJSON = new JSONObject(result.toString());
                    //Accedemos al vector de resultados...

                    String res = respuestaJSON.getString("valido");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "Pendiente de retorno";
    }
}
