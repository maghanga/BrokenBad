package com.thinknehru.BrokenBad.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.BrokenBadArrayAdapter;
import com.thinknehru.BrokenBad.models.BrokenBadCharacter;
import com.thinknehru.BrokenBad.models.Character;
import com.thinknehru.BrokenBad.network.BrokenBadApi;
import com.thinknehru.BrokenBad.network.BrokenBadClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListActivity extends AppCompatActivity {
    private static final String TAG = CharacterListActivity.class.getSimpleName();

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.listView) ListView mListView;

    public List<Character> characters;

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCharacters() {
        mListView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        BrokenBadApi client = BrokenBadClient.getClient();
        Call<List<Character>> call = client.getCharacters();




        Log.v("mymessage", String.valueOf(call.request().url()));

        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {

                hideProgressBar();

               if(response.isSuccessful()) {
                   List<Character> characterList = response.body();
                   String[] characters = new String[characterList.size()];


                   for(int i = 0; i < characters.length; i++){
                       characters[i] = characterList.get(i).getName();
                   }

                   ArrayAdapter adapter = new BrokenBadArrayAdapter(CharacterListActivity.this, android.R.layout.simple_list_item_1, characters);
                   mListView.setAdapter(adapter);

                   showCharacters();

               } else {
                   showUnsuccessfulMessage();
               }
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }
        });



    }
}
