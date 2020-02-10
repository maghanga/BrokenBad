package com.thinknehru.BrokenBad.ui;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.models.BrokenBadCharacter;
import com.thinknehru.BrokenBad.models.Character;
import com.thinknehru.BrokenBad.network.BrokenBadApi;
import com.thinknehru.BrokenBad.network.BrokenBadClient;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListActivity extends AppCompatActivity {
    private static final String TAG = CharacterListActivity.class.getSimpleName();

    @BindView(R.id.resultTextView)
    TextView mResultTextView;
//    @BindView(R.id.progressBar)
//    ProgressBar mProgressBar;
    @BindView(R.id.listView)
    ListView mListView;

    public List<Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        BrokenBadApi client = BrokenBadClient.getClient();
        Call<BrokenBadCharacter> call = client.getCharacters();




//        Log.v("mymessage", String.valueOf(call.request().url()));

        call.enqueue(new Callback<BrokenBadCharacter>() {
            @Override
            public void onResponse(Call<BrokenBadCharacter> call, Response<BrokenBadCharacter> response) {
               if(response.isSuccessful()){
                   List<Character> characterList = response.body().getCharacters();
                   String[] characters = new String[characterList.size()];


                   for(int i = 0; i < characters.length; i++){
                       characters[i] = characterList.get(i).getName();
                   }

                   ArrayAdapter adapter = new BrokenBadArrayAdapter(CharacterListActivity.this, android.R.layout.simple_list_item_1, characters);

               }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {

            }
        });



    }
}
