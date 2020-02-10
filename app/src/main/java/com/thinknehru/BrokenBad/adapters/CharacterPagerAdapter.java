package com.thinknehru.BrokenBad.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.thinknehru.BrokenBad.models.Character;
import com.thinknehru.BrokenBad.ui.CharacterDetailFragment;

import java.util.List;

public class CharacterPagerAdapter extends FragmentPagerAdapter {
    private List<Character> mCharacters;

    public CharacterPagerAdapter(FragmentManager fm, int behavior, List<Character> characters){
        super(fm, behavior);
        mCharacters = characters;
    }

    @Override
    public Fragment getItem(int position) {
        return CharacterDetailFragment.newInstance(mCharacters.get(position));
    }

    @Override
    public int getCount(){
        return mCharacters.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCharacters.get(position).getName();
    }
}
