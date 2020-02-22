package com.thinknehru.BrokenBad.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.models.Character;
import com.thinknehru.BrokenBad.models.Constants;
import com.thinknehru.BrokenBad.ui.CharacterDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class FirebaseCharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseCharacterViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }


    public void bindCharacter(Character character) {
        ImageView characterImageView = (ImageView) mView.findViewById(R.id.characterImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.characterNameTextView);
        TextView nicknameTextView = (TextView) mView.findViewById(R.id.nicknameTextView);
        TextView statusTextView = (TextView) mView.findViewById(R.id.statusTextView);

        Picasso.get().load(character.getImg()).into(characterImageView);

        nameTextView.setText(character.getName());
        nicknameTextView.setText(character.getNickname());
        statusTextView.setText(character.getStatus());
    }

    @Override
    public void onClick(View view) {
        final List<Character> characters = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CHARACTERS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    characters.add(snapshot.getValue(Character.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, CharacterDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(characters));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
