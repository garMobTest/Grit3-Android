package com.ibm.browna.grit3_android.Views.Assessments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.browna.grit3_android.Models.Tumbler;
import com.ibm.browna.grit3_android.R;


/**
 * Created by browna on 2/2/2017.
 */

public class PickerFragment extends Fragment {


    Button mSaveButton;
    Tumbler mTumbler1, mTumbler2, mTumbler3,mTumbler4;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_word_pick,null,false);


        String [] tumblerWords = {"Hat", "Cat", "Words", "Sit"};
        mTumbler1 = new Tumbler(R.id.leftArrow1,R.id.RightArrow1, R.id.word_tumbler1, tumblerWords,1);
        mTumbler2 = new Tumbler(R.id.leftArrow2,R.id.RightArrow2,R.id.word_tumbler2, tumblerWords,2);
        mTumbler3 = new Tumbler(R.id.leftArrow3,R.id.RightArrow3,R.id.word_tumbler3, tumblerWords,3);
        mTumbler4 = new Tumbler(R.id.leftArrow4,R.id.RightArrow4,R.id.word_tumbler4, tumblerWords,4);

        createTumbler(v, mTumbler1);
        createTumbler(v, mTumbler2);
        createTumbler(v, mTumbler3);
        createTumbler(v, mTumbler4);

        mSaveButton = (Button) v.findViewById(R.id.picker_save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AssessmentActivity)getActivity()).storyButton.callOnClick();
            }
        });

        return v;
    }

    private void createTumbler(View v, final Tumbler tumbler){
        final TextView textView =(TextView) v.findViewById(tumbler.getmWordsTV());
        ImageView leftArrow = (ImageView) v.findViewById(tumbler.getmLeftArrow());
        ImageView rightArrow = (ImageView) v.findViewById(tumbler.getmRightArrow());

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tumbler.setmCurrentWord(tumbler.getmCurrentWord()==3?0:tumbler.getmCurrentWord()+1);
                String newText = (tumbler.getmWordArray())[tumbler.getmCurrentWord()];
                textView.setText(newText);
            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tumbler.setmCurrentWord(tumbler.getmCurrentWord()==0?3:tumbler.getmCurrentWord()-1);
                String newText = (tumbler.getmWordArray())[tumbler.getmCurrentWord()];
                textView.setText(newText);
            }
        });

    }


}
