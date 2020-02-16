package com.thinknehru.BrokenBad.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.BrokenBadArrayAdapter;
import com.thinknehru.BrokenBad.adapters.CharacterListAdapter;
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
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private CharacterListAdapter mAdapter;

    public List<Character> characters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();


        BrokenBadApi client = BrokenBadClient.getClient();

        Call<List<Character>> call = client.getCharacters();




        Log.v("mymessage", String.valueOf(call.request().url()));

        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {

                hideProgressBar();

               if(response.isSuccessful()) {
                   characters = response.body();
                   mAdapter = new CharacterListAdapter(characters, CharacterListActivity.this);
                   mRecyclerView.setAdapter(mAdapter);
                   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CharacterListActivity.this);
                   new LinearLayoutManager(CharacterListActivity.this);
                   mRecyclerView.setLayoutManager(layoutManager);
                   mRecyclerView.setHasFixedSize(true);


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

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCharacters() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
