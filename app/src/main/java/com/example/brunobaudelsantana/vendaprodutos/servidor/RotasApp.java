package com.example.brunobaudelsantana.vendaprodutos.servidor;

import com.example.brunobaudelsantana.vendaprodutos.modelo.Result;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface RotasApp {

    @POST("cells.json")
    Call<Result> getCells();



    @GET("fund.json")
    Call<Result> getFound();

}
