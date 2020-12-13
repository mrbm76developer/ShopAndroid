package com.example.login_signup.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_signup.Engine.Utils;
import com.example.login_signup.R;

public class SplashActivity extends AppCompatActivity {
    private Button btnSplashLogin, btnSplashSignUp;
    private ImageView imgSplash;
    private TextView txtSplash;
    private Utils util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        util = new Utils(this, this);
        if ((Boolean) util.getSharedPreferences("isLogin", false))
            util.goToPage(MainActivity.class);
        setContentView(R.layout.activity_splash);
        SetupView();
        btnSplashLogin.setOnClickListener(View -> {
            util.goToPage(LoginActivity.class);
            finish();
        });
        btnSplashSignUp.setOnClickListener(View -> {
            util.goToPage(SignUpActivity.class);
            finish();
        });
    }

    private void SetupView() {
        btnSplashLogin = findViewById(R.id.btnSplashLogin);
        btnSplashSignUp = findViewById(R.id.btnSplashSingUp);
        imgSplash = findViewById(R.id.imgSplash);
        txtSplash = findViewById(R.id.txtSplash);
    }
}