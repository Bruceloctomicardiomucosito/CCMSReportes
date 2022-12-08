package com.example.ccmsreportes.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ccmsreportes.api.LocalNetworkAPI;
import com.example.ccmsreportes.model.ResultReportes;
import com.example.ccmsreportes.service.ServiceRetrofit;

//importacion del retrofit
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        localNetworkAPI = ServiceRetrofit.getClient().create(LocalNetworkAPI.class);
        retrofit2.Call<ResultReportes> call = localNetworkAPI.getListReportes();
        call.enqueue(new Callback<ResultReportes>() {
            @Override
            public void onResponse(Call<ResultReportes> call, Response<ResultReportes> response) {
                if(response.isSuccessful()){
                    list.postValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ResultReportes> call, Throwable t) {
                list.postValue(null);
            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    private MutableLiveData<List<Reportes>> lista;

    public ListaReporteViewModel() {this.lista = new MutableLiveData<List<Reportes>>();}

    public LiveData<List<Reportes>> getReportes(){return lista;}

    public void setReportes(List<Reportes> list){this.lista.setValue(list);}
     */
}
