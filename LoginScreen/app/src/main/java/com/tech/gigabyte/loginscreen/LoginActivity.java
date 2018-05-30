package com.tech.gigabyte.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Method for an Activity OnCreate *default
        super.onCreate(savedInstanceState);
        setTitle(R.string.activity_login);
        setContentView(R.layout.activity_login);         // Passing Layout

        btnLogin = (Button) findViewById(R.id.btn);
        etEmail = (EditText) findViewById(R.id.etInputName);
        etPassword = (EditText) findViewById(R.id.etInputPassword);

        btnLogin.setOnClickListener(this);
    }

    //Return true if password is valid and false if password is invalid
    protected boolean validatePassword(String password) {
        if (password != null && password.length() > 9) {
            return true;
        } else {
            return false;
        }
    }

    //Return true if email is valid and false if email is invalid
    protected boolean validateEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public void onClick(View view) {
        if (!validateEmail(etEmail.getText().toString())) {         //Calling method of Email validation
            etEmail.setError("Invalid Email");
            etEmail.requestFocus();
        } else if (!validatePassword(etPassword.getText().toString())) {     //Calling method of Password validation
            etPassword.setError("Invalid Password");
            etPassword.requestFocus();
        } else {
            Intent intent = new Intent(LoginActivity.this, Welcome.class);       //Bundle
            Bundle bundle = new Bundle();
            bundle.putString("BundleName", etEmail.getText().toString().trim());
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

}

