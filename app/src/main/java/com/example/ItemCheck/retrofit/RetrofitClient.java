package com.example.ItemCheck.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * singleton pattern
 *
 */

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private static RetrofitAPI retrofitAPI;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("Http://10.0.2.2:8080/") // not localhost:8080
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitAPI.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitAPI getRetrofitAPI() {
        return retrofitAPI;
    }

}
