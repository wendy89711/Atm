package com.wen.atm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private String password;
    private String username;
    private EditText edPassword;
    private EditText edUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);
        username = edUsername.getText().toString();
        password = edPassword.getText().toString();
        if ("wendy".equals(username) && "0000".equals(password)) {
            setResult(RESULT_OK);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("登入訊息")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
