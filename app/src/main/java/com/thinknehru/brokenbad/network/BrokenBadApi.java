package com.thinknehru.brokenbad.network;

import com.thinknehru.brokenbad.models.BreakingBadCharacter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BrokenBadApi {
    @GET("/characters")
    Call<BreakingBadCharacter> getCharacters(
            @Query("name") String name
    );
}
