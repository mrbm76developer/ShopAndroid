package com.example.login_signup.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login_signup.Fragments.FragmentAccount;
import com.example.login_signup.Fragments.FragmentCart;
import com.example.login_signup.Fragments.FragmentCategory;
import com.example.login_signup.Fragments.FragmentHome;
import com.example.login_signup.Fragments.FragmentSearchFilter;
import com.example.login_signup.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView btnNav;
    FragmentHome home = new FragmentHome();
    FragmentAccount account = new FragmentAccount();
    FragmentCart cart = new FragmentCart();
    FragmentCategory category = new FragmentCategory();
    FragmentSearchFilter searchFilter = new FragmentSearchFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();

        btnNav.setSelectedItemId(R.id.item_home);
        getSupportFragmentManager().beginTransaction().add(R.id.frmMainActivity,home).commit();
        btnNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmMainActivity, home).commit();
                    break;
                case R.id.item_account:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmMainActivity, account).commit();
                    break;
                case R.id.item_cart:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmMainActivity, cart).commit();
                    break;
                case R.id.item_category:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmMainActivity, category).commit();
                    break;
                case R.id.item_search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmMainActivity, searchFilter).commit();
                    break;
            }
            return true;
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
    }
}