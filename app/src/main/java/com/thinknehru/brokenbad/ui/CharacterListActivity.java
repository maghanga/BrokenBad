package com.thinknehru.brokenbad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thinknehru.brokenbad.models.Character;
import com.thinknehru.brokenbad.R;
import com.thinknehru.brokenbad.network.BrokenBadApi;
import com.thinknehru.brokenbad.network.BrokenBadClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListActivity extends AppCompatActivity {
    @BindView(R.id.resultTextView)
    TextView mResultTextView;
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;
    @BindView(R.id.listView)
    ListView mListView;
    String content = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        BrokenBadApi client = BrokenBadClient.getClient();

        Call<Character> call = client.getCharacters();

        Log.v("mymessage", String.valueOf(call.request().url()));

        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
//                if(!response.isSuccessful()){
//                    mResultTextView.setText("Code: " + response.code());
//                    return;
//                }

                Character characters = response.body();
                Log.v("MyResponseBody", response.body().getName());
//                    content += "Name: " + characters.getName() + "\n";
//                    content += "Occupation: " + characters.getOccupation() + "\n";
//                    content += "Img: " + characters.getImg() + "\n";
//                    content += "Nickname: " + characters.getNickname() + "\n";

                    mResultTextView.setText(characters.getName());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                mResultTextView.setText(t.getMessage());
            }
        });

    }
}
