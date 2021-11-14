package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Login = findViewById(R.id.TxtViewLogin);
        Intent intent = getIntent();
        String login = intent.getStringExtra("Login");
        Login.setText("Welcome " + login);

    }
}