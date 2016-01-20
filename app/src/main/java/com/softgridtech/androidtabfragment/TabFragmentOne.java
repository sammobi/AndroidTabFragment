package com.softgridtech.androidtabfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class TabFragmentOne extends Fragment {
    FragmentManager tabfragmentManager;

    SeekBar mAgeSkbr;
    CheckBox mMaleCkh, mFemaleChk;
    EditText mNameEt;
    Button mSubmitBtn;
    TextView mAgeValueTv;
    View view;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.activity_tab_fragment_one, container, false);
        context = view.getContext();

        mAgeSkbr = (SeekBar) view.findViewById(R.id.inputSkbr);
        mAgeSkbr.setMax(80);
        mAgeSkbr.setProgress(0);

        mAgeSkbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // change progress text label with current seekbar value
                mAgeValueTv.setText("Your age is: " + progress + "years");
                // change action text label to changing


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setSecondaryProgress(seekBar.getProgress());

            }
        });
        mMaleCkh = (CheckBox) view.findViewById(R.id.maleChk);
        mMaleCkh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mMaleCkh.isChecked()) {

                    mFemaleChk.setChecked(false);
                }


            }
        });

        mFemaleChk = (CheckBox) view.findViewById(R.id.femaleChk);
        mFemaleChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mFemaleChk.isChecked()) {

                    mMaleCkh.setChecked(false);
                }


            }


        });
        mNameEt = (EditText) view.findViewById(R.id.inputNameEt);
        mSubmitBtn = (Button) view.findViewById(R.id.submitBtn);
        mAgeValueTv = (TextView) view.findViewById(R.id.ageValueTv);


        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = mAgeValueTv.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("MyAge", input);

                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TabFragmentTwo fragmentTwo = new TabFragmentTwo();
                fragmentTwo.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentContainer, fragmentTwo);


                // it is used to maintain history of the state of the fragments on top of each other.
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return view;

    }


}
