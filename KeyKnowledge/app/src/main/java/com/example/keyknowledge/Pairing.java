package com.example.keyknowledge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.keyknowledge.control.PairingControl;
import com.example.keyknowledge.model.User;

public class Pairing extends Activity {

    PairingControl control;
    User user;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();
        user=(User)i.getSerializableExtra("user");
        mode=i.getStringExtra("mode");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_player);
        control.createMatch(user,mode);
    }
}
