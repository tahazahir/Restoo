package com.example.hppc.rest;


import android.content.Context;
import android.util.Log;

import com.example.hppc.model.Plat;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class RestClient {

   private static String baseUrl = "http://192.168.0.132:8080/";

    private static RestClient instance;
    private Context context;

    public static RestClient getInstance(Context context) {
        instance = new RestClient(context);
        return instance;
    }

    private RestClient(Context context) {
        this.context = context;
    }


    public interface RestApiInterface {

        @GET("/RestoWebService/webapi/myresource/plats")
        Call<List<Plat>> getPlat();

    }

    private static RestApiInterface restApiInterface;

    public static RestApiInterface getClient() {
        if (restApiInterface == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl).
                            addConverterFactory(GsonConverterFactory.create()).build();
            restApiInterface = client.create(RestApiInterface.class);

        }

        return restApiInterface;
    }


    public void getPlat(final RestDelegate delegate) {
        RestClient.RestApiInterface service = RestClient.getClient();
        Call<List<Plat>> call = service.getPlat();
        call.enqueue(new Callback<List<Plat>>() {

            @Override
            public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {

                Log.e("NXM", "Failure calling  '" +  new Gson().toJson(response) + "'");

                if (response.isSuccessful()) {
                    // request successful (status code 200, 201)
                    List<Plat> plats = response.body();
                    delegate.onSuccess(plats);
                } else if (response.code() == 403 || response.code() == 405) {
                    delegate.forbidden();

                } else {
                    delegate.onError(response.code(), response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Plat>> call, Throwable t) {
                Log.e("NXM", "Failure calling  '" + t.getMessage() + "'");
                delegate.onError(-1, t.getMessage());
            }

        });
    }


}