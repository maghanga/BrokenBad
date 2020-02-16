package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
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
    @BindView(R.id.favouriteCharactersButton) Button mFavouriteCharactersButton;


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
        mFavouriteCharactersButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    public  void onClick(View v){
        if(v == mViewCharactersButton) {
            Intent intent = new Intent(MainActivity.this, CharacterListActivity.class);
            startActivity(intent);
        }

        if (v == mFavouriteCharactersButton) {
            Intent intent = new Intent(MainActivity.this, FavouriteCharactersListActivity.class);
            startActivity(intent);
        }
    }
}



