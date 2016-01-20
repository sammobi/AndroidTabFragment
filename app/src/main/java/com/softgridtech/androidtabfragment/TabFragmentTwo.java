package com.softgridtech.androidtabfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragmentTwo extends Fragment {
    View view;
    Context context;
    FragmentManager tabFragmentManager;

    TextView mViewTv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.activity_tab_fragment_two, container, false);
        context = view.getContext();

        mViewTv = (TextView) view.findViewById(R.id.valueTabFragmentTv);


        final Bundle bundle = getArguments();
        if (null != bundle) {
            String input = bundle.getString("MyAge");

            mViewTv.setText(input);


        }


        return view;
    }
}
