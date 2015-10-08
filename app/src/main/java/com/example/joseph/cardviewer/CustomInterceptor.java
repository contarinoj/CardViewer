package com.example.joseph.cardviewer;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Joseph on 2015-10-07.
 */
public class CustomInterceptor implements Interceptor{

    private static final String APP_ID = "emhkdJtmryB7Fz5POLebWAZv4ynahCqaNQJjrrPG";
    private static final String REST_API_KEY = "poh1wTRHFUvtpUI9VSAirWHH8EyziFhmIdg5MIAz";
    private static final String APP_THING = "X-Parse-Application-Id";
    private static final String REST_API_THING = "X-Parse-REST-API-Key";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader(APP_THING,APP_ID).addHeader(REST_API_THING, REST_API_KEY).build();

        return chain.proceed(newRequest);
    }
}
