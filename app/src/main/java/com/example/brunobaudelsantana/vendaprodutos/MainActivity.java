package com.example.brunobaudelsantana.vendaprodutos;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.brunobaudelsantana.vendaprodutos.databinding.ActivityMainBinding;
import com.example.brunobaudelsantana.vendaprodutos.modelo.Cell;
import com.example.brunobaudelsantana.vendaprodutos.modelo.Result;
import com.example.brunobaudelsantana.vendaprodutos.servidor.RotasApp;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createRetrofit();
            }
        });
    }


    private void createRetrofit(){


        String API_BASE_URL = "https://floating-mountain-50292.herokuapp.com/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(httpClient.build()).build();

        RotasApp client =  retrofit.create(RotasApp.class);


        Call<Result> call =  client.getCells();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                   for(Cell cell : response.body().getCells()){
                        cell.getId();
                   }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

    }
}
