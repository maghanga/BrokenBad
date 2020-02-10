package com.thinknehru.BrokenBad.network;

import com.thinknehru.BrokenBad.models.BrokenBadCharacter;
import com.thinknehru.BrokenBad.models.Character;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrokenBadApi {
    @GET("characters")
    Call<BrokenBadCharacter> getCharacters();
}
