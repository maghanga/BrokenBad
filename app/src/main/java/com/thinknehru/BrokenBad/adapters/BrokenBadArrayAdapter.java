package com.thinknehru.BrokenBad.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class BrokenBadArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCharacters;

    public BrokenBadArrayAdapter(Context mContext, int resource, String[] mCharacters){
        super(mContext, resource);
        this.mContext = mContext;
        this.mCharacters = mCharacters;
    }

    @Override
    public Object getItem(int position){
        String character = mCharacters[position];
        return String.format("%s is a Breaking Bad character", character);
    }

    @Override
    public int getCount(){
        return mCharacters.length;
    }

}
