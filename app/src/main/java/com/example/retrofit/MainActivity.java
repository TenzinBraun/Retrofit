package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.bean.Planets;
import com.example.retrofit.bean.Pokemon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Callback<Pokemon> {


    static final String BASE_API_URL = "https://api.pokemontcg.io/v1/";


    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetApi gerritAPI = retrofit.create(GetApi.class);


        Call<Pokemon> call = gerritAPI.getPokemons();
        call.enqueue(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }


    @Override
    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
        if(response.isSuccessful()) {
            Pokemon pokemon = response.body();
            pokemon.getCards().forEach(result -> Log.d("WOWOWOWW", result.getName()));
        } else {
            Log.d("WOWOWOWW2",response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<Pokemon> call, Throwable t) {
        Log.d("WOWOWOWW3", t.getMessage());
    }

    public interface GetApi {

        @GET("cards/")
        Call<Pokemon> getPokemons();
    }
}
