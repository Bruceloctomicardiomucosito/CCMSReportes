package com.example.ccmsreportes.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ccmsreportes.Login;
import com.example.ccmsreportes.api.LocalNetworkAPI;
import com.example.ccmsreportes.model.ResultReportes;
import com.example.ccmsreportes.service.ServiceRetrofit;

//importacion del retrofit
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import android.widget.Toast;

public class ListaReporteViewModel extends ViewModel{
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private MutableLiveData<ResultReportes> list;
    private LocalNetworkAPI localNetworkAPI;

    public ListaReporteViewModel(){
        this.list = new MutableLiveData<ResultReportes>();
        //return lista;
    }
    public  LiveData<ResultReportes> getReportes(){return list;}
    public void setReporte(ResultReportes list){this.list.setValue(list);}
    /////Llamar al servicio
    public void CallServiceGetReporte(int page){

        localNetworkAPI = ServiceRetrofit.getListReportes().create(LocalNetworkAPI.class);

        retrofit2.Call<ResultReportes> call = localNetworkAPI.getListReportes(1);///Aqui le mandas el id de lo que quieres consultar
        ///Esta es la respuesta de la consulta.....
        call.enqueue(new Callback<ResultReportes>() {
            @Override
            ///Creo que aqui hay algo qeu tiene que ver con que no me muestre nada xdxdxd
            public void onResponse(Call<ResultReportes> call, Response<ResultReportes> response) {
                Log.i("ubicacion","inicio de metodo");
                if(response.isSuccessful()){
                    Log.i("ubicacion",response.body().getReporte().toString());
                    list.postValue(response.body());
                }
            }///Simona simona.. no sabemos si trae los datos.. tienes razon ... a ver .. toy ivestigando como imndo com inrpimir los JSONS
            @Override ///Creo que ya lo encontré y estpa vuelto loco xd toy viendo com o depurar
            ///Le di en debuggear... a ver  cuanto se tarda esta cosa xdxdxd
            ///Paciencia
            public void onFailure(Call<ResultReportes> call, Throwable t) {
                Log.i("ubicacion","Entra al else");
            }
        }); ////chiale.. no sé como comstrar esos logs en java xdxd deja veo como a ver que encuentro
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    private MutableLiveData<List<Reportes>> lista;

    public ListaReporteViewModel() {this.lista = new MutableLiveData<List<Reportes>>();}

    public LiveData<List<Reportes>> getReportes(){return lista;}

    public void setReportes(List<Reportes> list){this.lista.setValue(list);}
     */
}
