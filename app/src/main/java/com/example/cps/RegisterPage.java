package com.example.cps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    private static String KEY_NAME = "name";
    private static String KEY_ID = "stdid";
    private static String KEY_ADMN = "admn";
    private static String KEY_CLASS = "class";
    private static String KEY_ROLL = "roll";
    private static String KEY_PASSWORD = "password";
    private static String KEY_CONFIRMPASSWORD = "confirmPassword";


    private String spName = "com.prabhakar.CPS";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_register_page);
    }

    public void switchToSuccessActivity(View view){



        EditText etName = findViewById(R.id.regName);
        EditText etId = findViewById(R.id.regUserId);
        EditText etAdmn = findViewById(R.id.regAdmnNo);
        EditText etClass = findViewById(R.id.regClass);
        EditText etRoll = findViewById(R.id.regRoll);
        EditText etPassword = findViewById(R.id.regPassword);
        EditText etConfirm = findViewById(R.id.regConfirm);

        String stdName = etName.getText().toString();
        String stdId = etId.getText().toString();
        String stdAdmn = etAdmn.getText().toString();
        String stdClass = etClass.getText().toString();
        String stdRoll = etRoll.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirm.getText().toString();
//
//        if(password == confirmPassword){
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putString(KEY_NAME, stdName);
            editor.putString(KEY_ID, stdId);
            editor.putString(KEY_ADMN, stdAdmn);
            editor.putString(KEY_CLASS, stdClass);
            editor.putString(KEY_ROLL, stdRoll);
            editor.putString(KEY_PASSWORD, password);
            editor.putString(KEY_CONFIRMPASSWORD, confirmPassword);

            boolean success = editor.commit();

            Toast.makeText(getApplicationContext(), success? "Hurray!!! Profile Successfully Created.\nNow LOGIN " : "Please enter again",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
//        } else {
//            Toast.makeText(getApplicationContext(), "Password and Confirm Password should be same", Toast.LENGTH_SHORT).show();
//        }
    }

    public void switchToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}