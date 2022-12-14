package com.example.ccmsreportes.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRetrofit {
    //// necesitamos modificar la ruta de la api
    public static String BASE_URL = "http://192.168.100.5:3000/";
    //public static String BASE_URL = "http://192.168.100.5:3000/";
    private static Retrofit INSTANCE = null;
    public static Retrofit getClient(){
        if (INSTANCE==null){
            INSTANCE = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return INSTANCE;
    }
}
