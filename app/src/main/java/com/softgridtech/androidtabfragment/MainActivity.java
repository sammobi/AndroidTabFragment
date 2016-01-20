package com.softgridtech.androidtabfragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends FragmentActivity {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowTabFragmentOne(View view) {

        fragmentManager = (this).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TabFragmentOne tabFragmentOne = new TabFragmentOne();
        fragmentTransaction.remove(tabFragmentOne);

        fragmentTransaction.add(R.id.fragmentContainer, tabFragmentOne);


        // it is used to maintain history of the state of the fragments on top of each other.
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

}
