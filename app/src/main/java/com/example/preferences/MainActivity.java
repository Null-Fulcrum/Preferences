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


public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button Submit;
    Button Registration;
    EditText Login;
    EditText Password;
    SharedPreferences fPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Submit = findViewById(R.id.BtnEnter);
        Registration = findViewById(R.id.BtnReg);
        Login = findViewById(R.id.editTextAuthLogin);
        Password = findViewById(R.id.editTextAuthPassword);
        Submit.setOnClickListener(this);
        Registration.setOnClickListener(this);
        loadText();

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.BtnEnter:
                Intent intent1 = new Intent(this,UserActivity.class);
                intent1.putExtra("Login",Login.getText().toString());
                startActivity(intent1);
                break;
            case R.id.BtnReg:
                Intent intent = new Intent(this,RegistrationActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    void loadText() {
        fPref = getSharedPreferences("Auth",MODE_PRIVATE);
        String login = fPref.getString("Login", "");
        String password = fPref.getString("Password", "");
        Login.setText(login);
        Password.setText(password);
    }


}