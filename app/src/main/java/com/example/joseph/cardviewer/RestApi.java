package com.example.joseph.cardviewer;



import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Joseph on 2015-10-07.
 */
public interface RestApi {

    @GET("/1/classes/{type}")
    Call<ParseResponse<Card>> getCards(@Path("type") CharSequence type);
}
