package com.example.myflexiblefragment1037;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        HomeFragment hf = new HomeFragment();
        ft.add(R.id.frame_container, hf, HomeFragment.class.getSimpleName());

        Log.d("MyFlexibleFragment", "Fragment name:"+HomeFragment.class.getSimpleName());
        ft.commit();
    }
}