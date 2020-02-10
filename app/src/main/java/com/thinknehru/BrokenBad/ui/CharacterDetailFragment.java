package com.thinknehru.BrokenBad.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thinknehru.BrokenBad.R;
import com.thinknehru.BrokenBad.models.Character;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterDetailFragment extends Fragment {
    @BindView(R.id.characterImageView)
    ImageView mImageLabel;
    @BindView(R.id.characterNameTextView)
    TextView mNameLabel;
    @BindView(R.id.portrayedTextView) TextView mPortrayedLabel;
    @BindView(R.id.occupationTextView) TextView mOccupationLabel;
    @BindView(R.id.appearanceTextView) TextView mAppearanceLabel;
    @BindView(R.id.birthdayTextView) TextView mBirthdayLabel;
    @BindView(R.id.nicknameTextView) TextView mNicknameLabel;
    @BindView(R.id. statusTextView) TextView mStatusLabel;
    @BindView(R.id.saveCharacterButton) TextView mSaveCharacterButton;

    private Character mCharacter;

    public CharacterDetailFragment() {
        // Required empty public constructor
    }

    public static CharacterDetailFragment newInstance(Character character) {
            CharacterDetailFragment characterDetailFragment = new CharacterDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(character));
        characterDetailFragment.setArguments(args);
        return characterDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCharacter = Parcels.unwrap(getArguments().getParcelable("character"));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mCharacter.getImg()).into(mImageLabel);

        List<String> occupations = mCharacter.getOccupation();
        List<Integer> appearances = mCharacter.getAppearance();


        mNameLabel.setText(mCharacter.getName());
        mNicknameLabel.setText(mCharacter.getNickname());
        mBirthdayLabel.setText(mCharacter.getBirthday());
        mStatusLabel.setText(mCharacter.getStatus());
        mOccupationLabel.setText(android.text.TextUtils.join(", ", occupations));
        mAppearanceLabel.setText(android.text.TextUtils.join(", ", appearances));


        return view;
    }

}
