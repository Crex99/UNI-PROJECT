package com.example.keyknowledge;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.keyknowledge.control.*;
import com.example.keyknowledge.model.User;

public class Login extends Activity {

    SharedPreferences pref;
    EditText us,pass;

    LoginControl control=new LoginControl(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref=getSharedPreferences("profile",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        us=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
    }
    public void message(String x){
        Toast.makeText(this,x, Toast.LENGTH_LONG).show();
    }

    public void access(View view) {
        control.access(us.getText().toString(),pass.getText().toString());
    }


}
