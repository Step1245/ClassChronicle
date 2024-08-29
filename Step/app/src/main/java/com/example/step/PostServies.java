package com.example.step;

import com.example.step.PostServies;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface PostServies {
    @GET("/api/dev/sheet")
    public Call<ArrayList<ArrayList<String>>> getData(@Query("sheet_id") String id, @Query("pwd") String pwd);

}
