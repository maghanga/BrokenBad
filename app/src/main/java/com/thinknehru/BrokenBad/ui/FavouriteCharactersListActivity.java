package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.FirebaseCharacterViewHolder;
import com.thinknehru.BrokenBad.models.Character;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouriteCharactersListActivity extends AppCompatActivity {

    private DatabaseReference mCharacterReference;
    private FirebaseRecyclerAdapter<Character, FirebaseCharacterViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);
        ButterKnife.bind(this);
    }
}
