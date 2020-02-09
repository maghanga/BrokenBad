package com.thinknehru.brokenbad.network;

import android.app.DownloadManager;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.thinknehru.brokenbad.models.Constants.YELP_BASE_URL;

public class BrokenBadClient {
    private static BrokenBadApi getClient(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(YELP_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create( BrokenBadApi.class);
    }
}