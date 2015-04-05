package com.connectu.connectu_android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    public static final String PREFS_NAME = "prefs";
    SharedPreferences prefs;
    EditText user_id = null;
    EditText user_password = null;
    Button login_but;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        final String username = prefs.getString("username", null);
        final String password = prefs.getString("password", null);


        if (username != null && password != null){

            setContentView(R.layout.activity_login);

            user_id = (EditText) findViewById(R.id.edittext_id);
            user_password = (EditText) findViewById(R.id.edittext_password);
            login_but = (Button) findViewById(R.id.button_login);

            login_but.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    try {
                        if(username.equalsIgnoreCase(user_id.getText().toString()) && password.equals(user_password.getText().toString())) {
                            Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            //startActivity(new Intent(LoginActivity.this,MainActivity.class));
            //finish();
            setContentView(R.layout.activity_login);
        }
    }
}
