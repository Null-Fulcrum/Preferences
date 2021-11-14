package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements OnClickListener{
    SharedPreferences sPref;
    EditText Login;
    EditText Password;
    Button Enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Login = findViewById(R.id.editTextRegLogin);
        Password = findViewById(R.id.editTextRegPassword);
        Enter = findViewById(R.id.BtnRegEnter);
        Enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnRegEnter:
                saveText();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    void saveText() {
        sPref = getSharedPreferences("Auth",MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString("Login", Login.getText().toString());
        ed.putString("Password", Password.getText().toString());
        ed.commit();
    }


}