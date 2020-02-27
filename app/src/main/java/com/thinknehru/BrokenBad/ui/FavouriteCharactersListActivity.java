package com.thinknehru.BrokenBad.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.CharacterListAdapter;
import com.thinknehru.BrokenBad.adapters.FirebaseCharacterViewHolder;
import com.thinknehru.BrokenBad.models.Character;
import com.thinknehru.BrokenBad.models.Constants;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FavouriteCharactersListActivity extends AppCompatActivity {
    private static final String TAG = CharacterListActivity.class.getSimpleName();

    private DatabaseReference mCharacterReference;
    private FirebaseRecyclerAdapter<Character, FirebaseCharacterViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    private CharacterListAdapter mAdapter;

    public List<Character> characters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);

        mCharacterReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CHARACTERS);
        setUpFirebaseAdapter();

        hideProgressBar();
        showCharacters();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Character> options =
                new FirebaseRecyclerOptions.Builder<Character>()
                        .setQuery(mCharacterReference, Character.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Character, FirebaseCharacterViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCharacterViewHolder firebaseCharacterViewHolder, int position, @NonNull Character character) {
                firebaseCharacterViewHolder.bindCharacter(character);
            }

            @NonNull
            @Override
            public FirebaseCharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item, parent, false);
                return new FirebaseCharacterViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }



    private void showCharacters() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
