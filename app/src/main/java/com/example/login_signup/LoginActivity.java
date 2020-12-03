package com.example.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edtUserNameLogin, edtPasswordLogin;
    private TextInputLayout edtUserNameLoginLayout, edtPasswordLoginLayout;
    private Button btnLogin;
    private Button btnSignUp;
    DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetupView();
        db = new DbManager(LoginActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameLogin = edtUserNameLogin.getText().toString().trim();
                String passwordLogin = edtPasswordLogin.getText().toString().trim();
                People user = db.searchUser(userNameLogin);
                if (user != null) {
                    if (user.getPassword().equals(passwordLogin)) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    edtUserNameLoginLayout.setError("نام کاربری یا رمز عبور اشتباه است!");
                    edtPasswordLoginLayout.setError("نام کاربری یا رمز عبور اشتباه است!");
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void SetupView() {
        edtUserNameLogin = findViewById(R.id.edtUserNameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        edtUserNameLoginLayout = findViewById(R.id.edtUserNameLoginLayout);
        edtPasswordLoginLayout = findViewById(R.id.edtPasswordLoginLayout);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
    }
}