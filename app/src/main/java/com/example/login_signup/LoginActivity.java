package com.example.login_signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_signup.model.People;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    DbManager db;
    private TextInputEditText edtUserNameLogin, edtPasswordLogin;
    private TextInputLayout edtUserNameLoginLayout, edtPasswordLoginLayout;
    private Button btnLogin;
    private Button btnSignUp;
    private Utils util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupView();
        db = new DbManager(LoginActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameLogin = edtUserNameLogin.getText().toString().toLowerCase().trim();
                String passwordLogin = edtPasswordLogin.getText().toString().trim();
                People user = db.searchUser(userNameLogin);
                if (user != null) {
                    if (user.getPassword().equals(passwordLogin)) {
                        util.setSharedPreferences("isLogin", true);
                        util.goToPage(LoginActivity.this, MainActivity.class);
                        finish();
                    }
                } else {
                    edtUserNameLoginLayout.setError(getString(R.string.user_pass));
                    edtPasswordLoginLayout.setError(getString(R.string.user_pass));
                }
            }
        });
        btnSignUp.setOnClickListener(view -> {
            util.goToPage(LoginActivity.this, SignUpActivity.class);
        });

    }

    private void SetupView() {
        util = new Utils(LoginActivity.this);
        edtUserNameLogin = findViewById(R.id.edtUserNameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        edtUserNameLoginLayout = findViewById(R.id.edtUserNameLoginLayout);
        edtPasswordLoginLayout = findViewById(R.id.edtPasswordLoginLayout);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
}