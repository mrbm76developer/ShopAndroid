package com.example.login_signup.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.login_signup.R;

public class FragmentCategory extends Fragment {


    public FragmentCategory() {

    }

    public static FragmentCategory newInstance() {
        return new FragmentCategory();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_categorys, container, false);
    }
}