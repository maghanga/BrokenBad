package com.thinknehru.brokenbad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.thinknehru.brokenbad.R;
import com.thinknehru.brokenbad.models.BreakingBadCharacter;
import com.thinknehru.brokenbad.network.BrokenBadApi;
import com.thinknehru.brokenbad.network.BrokenBadClient;

import java.util.List;

import retrofit2.Call;

public class CharacterListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        BrokenBadApi client = BrokenBadClient.getClient();

        Call<List<BreakingBadCharacter>> call = client.getCharacters();

    }
}
