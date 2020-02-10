package com.thinknehru.BrokenBad.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.adapters.CharacterPagerAdapter;
import com.thinknehru.BrokenBad.models.Character;

import org.parceler.Parcels;

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

        mCharacters = Parcels.unwrap(getIntent().getParcelableExtra("characters"));

        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new CharacterPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mCharacters);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}
