package com.example.joseph.cardviewer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Joseph on 2015-10-07.
 */
public class RestClient {
    private static RestApi client;
    private static final String ENDPOINT = "https://api.parse.com/";


    private static void setUpRestClient(){
        OkHttpClient newHttpClient = new OkHttpClient();
        newHttpClient.networkInterceptors().add(new CustomInterceptor());
        Gson gson = new GsonBuilder().registerTypeAdapter(Card.class, new CardDeserializer()).create();

        client = new Retrofit
                .Builder()
                .baseUrl(ENDPOINT)
                .client(newHttpClient)
                .addConverterFactory( GsonConverterFactory.create(gson) )
                .build()
                .create(RestApi.class);
    }

    public static RestApi getClient(){
        if(client == null)
            setUpRestClient();

        return client;
    }
}
