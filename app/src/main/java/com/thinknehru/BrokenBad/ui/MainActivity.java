package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.models.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private DatabaseReference mSearchedCharacterReference;

    @BindView(R.id.viewCharactersButton)
    Button mViewCharactersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        mSearchedCharacterReference = FirebaseDatabase
//                .getInstance()
//                .getReference()
//                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mViewCharactersButton.setOnClickListener(this);

    }

    @Override
    public  void onClick(View v){
        if(v == mViewCharactersButton) {
            Intent intent = new Intent(MainActivity.this, CharacterListActivity.class);
            startActivity(intent);
        }
    }
}



