package com.example.login_signup;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private Button btnSplashLogin, btnSplashSignUp;
    private ImageView imgSplash;
    private TextView txtSplash;
    private Utils util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        util = new Utils(this);
        if ((Boolean) util.getSharedPreferences("isLogin", false))
            util.goToPage(SplashActivity.this, MainActivity.class);
        setContentView(R.layout.activity_splash);
        SetupView();
        btnSplashLogin.setOnClickListener(View -> {
            util.goToPage(SplashActivity.this, LoginActivity.class);
            finish();
        });
        btnSplashSignUp.setOnClickListener(View -> {
            util.goToPage(SplashActivity.this, SignUpActivity.class);
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