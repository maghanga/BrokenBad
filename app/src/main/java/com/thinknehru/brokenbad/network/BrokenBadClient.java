package com.thinknehru.brokenbad.network;

import android.app.DownloadManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class BrokenBadClient {
    private static BrokenBadApi getClient(){
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            DownloadManager.Request newRequest  = chain.request().newBuilder()
                                    .addHeader("Authorization", YELP_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(YELP_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(YelpApi.class);
    }
}