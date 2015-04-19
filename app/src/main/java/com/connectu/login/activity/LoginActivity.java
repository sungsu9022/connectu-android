package com.connectu.login.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.connectu.activity.MainActivity;
import com.connectu.activity.R;
import com.connectu.controller.SharedPreferenceController;
import com.connectu.login.model.LoginModel;

public class LoginActivity extends Activity {
    LoginModel loginModel;
    EditText editText_id;
    EditText editText_pw;
    Button button_login;
    Button button_join;
    CheckBox checkBox_autologin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_id = (EditText) findViewById(R.id.edittext_id);
        editText_pw = (EditText) findViewById(R.id.edittext_password);

        button_login = (Button) findViewById(R.id.button_login);
        button_join = (Button) findViewById(R.id.button_join);

        checkBox_autologin = (CheckBox) findViewById(R.id.checkbox_autologin);

        SharedPreferenceController pref = new SharedPreferenceController(LoginActivity.this);
        checkBox_autologin.setChecked(pref.getValue(SharedPreferenceController.PREF_USER_AUTOLOGIN, false));

        if(checkBox_autologin.isChecked())
        {
            loginModel.setIdentfication(pref.getValue(SharedPreferenceController.PREF_USER_ID, null));
            loginModel.setPassword(pref.getValue(SharedPreferenceController.PREF_USER_PASSWORD, null));

            editText_id.setText(loginModel.getIdentfication());
            editText_pw.setText(loginModel.getPassword());

            if(editText_id.getText().toString().equals("id") && editText_pw.getText().toString().equals("pw"))
            {
                Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
            else
            {
                Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
            }
        }

        button_login.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                try {
                    if (editText_id.getText().toString().equals("id") && editText_pw.getText().toString().equals("pw")) {
                        Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();

                        if (checkBox_autologin.isChecked())
                        {
                            SharedPreferenceController pref = new SharedPreferenceController(LoginActivity.this);
                            pref.put(SharedPreferenceController.PREF_USER_ID, editText_id.getText().toString());
                            pref.put(SharedPreferenceController.PREF_USER_PASSWORD, editText_pw.getText().toString());
                            pref.put(SharedPreferenceController.PREF_USER_AUTOLOGIN, true);
                        }
                        else
                        {
                            SharedPreferenceController pref = new SharedPreferenceController(LoginActivity.this);
                            pref.put(SharedPreferenceController.PREF_USER_AUTOLOGIN, false);
                        }

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        button_join.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_join);
            }
        });
    }
}
