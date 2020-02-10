package com.thinknehru.brokenbad.network;

import com.thinknehru.brokenbad.models.Character;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrokenBadApi {
    @GET("characters")
    Call<Character> getCharacters();
}
