package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.CharacterPagerAdapter;
import com.thinknehru.BrokenBad.models.Character;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private CharacterPagerAdapter adapterViewPager;
    List<Character> mCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        ButterKnife.bind(this);
    }
}
