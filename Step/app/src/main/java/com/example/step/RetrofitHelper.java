package com.example.step;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static Retrofit instance() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://lkf.kazandigitalweek.com/")
                .addConverterFactory (GsonConverterFactory.create())
                .build();
        return r;
    }
}
