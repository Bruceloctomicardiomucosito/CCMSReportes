package com.example.ccmsreportes.api;

<<<<<<< Updated upstream
=======
import com.example.ccmsreportes.model.DetallesReporte;
import com.example.ccmsreportes.model.InsertReporte;
>>>>>>> Stashed changes
import com.example.ccmsreportes.model.Reportes;
import com.example.ccmsreportes.model.ResultReportes;
import com.example.ccmsreportes.model.ResponseReporte;
import com.example.ccmsreportes.model.Usuario.LoginProfesor;
import com.example.ccmsreportes.model.Usuario.ProfesorResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LocalNetworkAPI {///Aaah si miira... aqui tengo la interface....
    //Codigo Original
      /*
    @GET("personas")
    Call<ResultPersonas> getListPersonas();

    @Headers({"Content-Type: application/json"})
    @POST("personas")
    Call<ResponsePersona> setPerson(@Body Persona persona);

    @Headers({"Content-Type: application/json"})
    @DELETE("personas/{id}")
    Call<ResponsePersona> setPerson(@Path("id") int id);

    @Headers({"Content-Type: application/json"})
    @PUT("personas/{id}")
    Call<ResponsePersona> setPerson(@Path("id") int id, @Body Persona persona);
*/
    @GET("/getReportesProfe/{idProf}") ///Recibe y envia el id ... aah entiendo ...
    Call<ResultReportes> getListReportes(@Path("idProf") int id); ////Zimon- aaah vamos para allá--- Se usa aaqui ...

    @Headers({"Content-Type: application/json"})
    @POST("addReporte")
    Call<ResponseReporte> setReporte(@Body InsertReporte reportes);

    @Headers({"Content-Type: application/json"})
    @POST("login")
    Call<ProfesorResponse> loginFun(@Body LoginProfesor proToLogin);

}