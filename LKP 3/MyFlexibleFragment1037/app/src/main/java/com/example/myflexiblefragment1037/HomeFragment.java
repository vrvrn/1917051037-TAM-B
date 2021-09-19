package com.example.myflexiblefragment1037;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnCategory = (Button) view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v){
        if (v.getId()==R.id.btn_category){
            CategoryFragment cf = new CategoryFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame_container, cf, CategoryFragment.class.getSimpleName());
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}