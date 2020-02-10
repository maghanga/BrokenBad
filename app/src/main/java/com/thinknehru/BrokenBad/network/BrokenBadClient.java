package com.thinknehru.BrokenBad.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.thinknehru.BrokenBad.models.Constants.YELP_BASE_URL;

public class BrokenBadClient {
    public static BrokenBadApi getClient(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(YELP_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create(BrokenBadApi.class);
    }
}