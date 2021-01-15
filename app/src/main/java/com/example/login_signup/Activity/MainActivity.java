package com.example.login_signup.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_signup.Engine.Utils;
import com.example.login_signup.Fragments.FragmentAccount;
import com.example.login_signup.Fragments.FragmentCart;
import com.example.login_signup.Fragments.FragmentCategory;
import com.example.login_signup.Fragments.FragmentHome;
import com.example.login_signup.Fragments.FragmentSearchFilter;
import com.example.login_signup.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Utils util;
    private BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        btnNav.setSelectedItemId(R.id.item_home);
        util.openFragment(FragmentHome.newInstance(MainActivity.this), R.id.frmMainActivity);
        btnNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_home:
                    return util.openFragment(FragmentHome.newInstance(MainActivity.this), R.id.frmMainActivity);
                case R.id.item_account:
                    return util.openFragment(FragmentAccount.newInstance(), R.id.frmMainActivity);
                case R.id.item_cart:
                    return util.openFragment(FragmentCart.newInstance(), R.id.frmMainActivity);
                case R.id.item_category:
                    return util.openFragment(FragmentCategory.newInstance(), R.id.frmMainActivity);
                case R.id.item_search:
                    return util.openFragment(FragmentSearchFilter.newInstance(), R.id.frmMainActivity);
            }
            return false;
        });


        // clickItemImageSlider(imgSliderMainActivity);
//        btn1.setOnClickListener(view -> {
//            util.setSharedPreferences("isLogin", false);
//            util.goToPage(SplashActivity.class);
//            finish();
//        });


    }


    private void setupView() {
        btnNav = findViewById(R.id.btnNav);
        util = new Utils(MainActivity.this, MainActivity.this);
    }
}