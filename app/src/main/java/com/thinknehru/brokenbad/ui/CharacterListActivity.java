package com.thinknehru.brokenbad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thinknehru.brokenbad.R;
import com.thinknehru.brokenbad.models.BreakingBadCharacter;
import com.thinknehru.brokenbad.network.BrokenBadApi;
import com.thinknehru.brokenbad.network.BrokenBadClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListActivity extends AppCompatActivity {
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        BrokenBadApi client = BrokenBadClient.getClient();

        Call<List<BreakingBadCharacter>> call = client.getCharacters();

        call.enqueue(new Callback<List<BreakingBadCharacter>>() {
            @Override
            public void onResponse(Call<List<BreakingBadCharacter>> call, Response<List<BreakingBadCharacter>> response) {

            }

            @Override
            public void onFailure(Call<List<BreakingBadCharacter>> call, Throwable t) {

            }
        });

    }
}
