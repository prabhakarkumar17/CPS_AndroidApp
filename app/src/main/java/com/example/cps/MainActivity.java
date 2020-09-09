package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String spName = "com.prabhakar.CPS";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    public void switchActivity(View view){

        EditText etLoginId = findViewById(R.id.loginId);
        EditText etPassword = findViewById(R.id.password);

        String etId = etLoginId.getText().toString();
        String etPswd = etPassword.getText().toString();
        String idValue = this.sharedPreferences.getString("stdid","No value");
        String nameValue = this.sharedPreferences.getString("name", "No name");
        String passwordValue = this.sharedPreferences.getString("password", "No password");

//        if(etId.equals(idValue) && etPswd.equals(passwordValue)){

            Intent intent = new Intent(this,ProfilePage.class);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(), nameValue, Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(),"Incorrect Details", Toast.LENGTH_SHORT).show();
//        }
    }

    public void registerActivity(View view){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

    public void subjectActivity(View view){
        Intent intent = new Intent(this, SubjectActivity.class);
        startActivity(intent);
    }
}