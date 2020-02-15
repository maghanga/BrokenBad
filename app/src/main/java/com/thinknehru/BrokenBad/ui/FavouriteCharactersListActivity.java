package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.FirebaseCharacterViewHolder;
import com.thinknehru.BrokenBad.models.Character;

public class FavouriteCharactersListActivity extends AppCompatActivity {

    private DatabaseReference mCharacterReference;
    private FirebaseRecyclerAdapter<Character, FirebaseCharacterViewHolder> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
    }
}
