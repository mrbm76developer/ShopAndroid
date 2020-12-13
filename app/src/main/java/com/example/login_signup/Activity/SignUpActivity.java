package com.example.login_signup.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_signup.Engine.Utils;
import com.example.login_signup.Modles.DbManager;
import com.example.login_signup.Modles.Model.People;
import com.example.login_signup.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    DbManager db;
    private TextInputEditText edtUserNameSingUp, edtPasswordSignUp, edtPasswordReplace;
    private TextInputLayout edtUserNameSingUpLayout, edtPasswordSignUpLayout, edtPasswordReplaceLayout;
    private Button btnSignUp2;
    private Button btnBack;
    private Utils util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        SetupView();
        db = new DbManager(SignUpActivity.this);
        util = new Utils(this, SignUpActivity.this);
        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUserNameSingUp.getText().toString().toLowerCase().trim();
                String password = edtPasswordSignUp.getText().toString().trim();
                String passwordReplace = edtPasswordReplace.getText().toString().trim();

                //Checked EditTexts Not Empty
                if (userName.equals("") && password.equals("") && passwordReplace.equals("")) {

                    //Text In TextViews Error
                    edtUserNameSingUpLayout.setError("لطفا فیلد را پر کنید");
                    edtPasswordSignUpLayout.setError("لطفا فیلد را پر کنید");
                    edtPasswordReplaceLayout.setError("لطفا فیلد را پر کنید");

                    //Checked EditText UserName Not Field Empty
                } else if (userName.equals("")) {
                    edtUserNameSingUpLayout.setError("لطفا فیلد را پر کنید");

                    //Checked EditText Password Not Field Empty
                } else if (password.equals("")) {
                    edtPasswordSignUpLayout.setError("لطفا فیلد را پر کنید");

                    // Password Replace Not Field Empty
                } else if (passwordReplace.equals("")) {
                    edtPasswordReplaceLayout.setError("لطفا فیلد را پر کنید");

                    //Checked EditTexts UserName,Password,PasswordReplace > = 5, 8, 8
                } else if (userName.length() < 5 && password.length() < 8 && passwordReplace.length() < 8) {

                    //Text Error
                    edtUserNameSingUpLayout.setError("نام کاربری باید بیش از پنج کاراکتر باشد");
                    edtPasswordSignUpLayout.setError("رمز عبور باید بیش از هشت کاراکتر باشد");
                    edtPasswordReplaceLayout.setError("رمز عبور باید بیش از هشت کاراکتر باشد");

                    //Checked Not UserName < 5
                } else if (userName.length() < 5) {

                    // Text In UserName TextView
                    edtUserNameSingUpLayout.setError("نام کاربری باید بیش از پنج کاراکتر باشد");

                    //Checked Not Password < 8
                } else if (password.length() < 8) {

                    // Text In Password TextView
                    edtPasswordSignUpLayout.setError("رمز عبور باید بیش از هشت کاراکتر باشد");

                    //Checked Not Password Replace < 8
                } else if (passwordReplace.length() < 8) {

                    //Visible TextView PasswordReplace And Text In PasswordReplace TextView
                    edtPasswordReplaceLayout.setError("رمز عبور باید بیش از هشت کاراکتر باشد");

                    //Checked Password Replace == Password
                } else if (!passwordReplace.equals(password)) {

                    // Text In PasswordReplace TextView
                    edtPasswordReplaceLayout.setError("مقدار فیلد های رمز عبور باید یکسان باشد");

                    //Next Page And Finish Page
                } else {
                    boolean flag = db.addPerson(new People(userName, password));
                    if (flag) {
                        util.setSharedPreferences("isLogin", true);
                        util.goToPage(MainActivity.class);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Not...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                util.goToPage(SplashActivity.class);
            }
        });
    }

    private void SetupView() {
        edtUserNameSingUp = findViewById(R.id.edtUserNameSingUp);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSingUp);
        edtPasswordReplace = findViewById(R.id.edtPasswordReplaceSingUp);
        edtUserNameSingUpLayout = findViewById(R.id.edtUserNameSingUpLayout);
        edtPasswordSignUpLayout = findViewById(R.id.edtPasswordSingUpLayout);
        edtPasswordReplaceLayout = findViewById(R.id.edtPasswordReplaceSingUpLayout);
        btnSignUp2 = findViewById(R.id.btnSignUp2);
        btnBack = findViewById(R.id.btnBack);
    }

}
