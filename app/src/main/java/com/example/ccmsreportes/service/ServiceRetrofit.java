package com.example.ccmsreportes.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRetrofit {
    //// necesitamos modificar la ruta de la api
    public static String BASE_URL = "http://192.168.1.13:3000/";
    //public static String BASE_URL = "http://192.168.100.5:3000/";
    private static Retrofit INSTANCE = null;
    public static Retrofit getListReportes(){
        OkHttpClient  client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        if (INSTANCE==null){
            INSTANCE = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return INSTANCE;
    }
}
