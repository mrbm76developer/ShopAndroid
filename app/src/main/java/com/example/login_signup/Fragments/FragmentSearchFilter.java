package com.example.login_signup.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.login_signup.R;

public class FragmentSearchFilter extends Fragment {

    public FragmentSearchFilter() {

    }

    public static FragmentSearchFilter newInstance() {
        return new FragmentSearchFilter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search_filter, container, false);
    }
}