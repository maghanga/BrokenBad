package com.thinknehru.brokenbad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thinknehru.brokenbad.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.viewCharactersButton)
    Button mViewCharactersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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



