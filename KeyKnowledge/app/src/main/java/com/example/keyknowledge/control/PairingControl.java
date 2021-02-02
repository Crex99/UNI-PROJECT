package com.example.keyknowledge.control;

import com.example.keyknowledge.Pairing;
import com.example.keyknowledge.model.PairingManager;
import com.example.keyknowledge.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class PairingControl {

    PairingManager manager;
    Pairing pairing;

    public PairingControl(Pairing p){
        pairing=p;
        manager=new PairingManager();
    }


    public void createMatch(User user,String mode){
        manager.createMatch(user,mode);
    }

    public void startMatch(String mode, User user, String opponent) {
        pairing.message("PARTITA DA INIZIARE");
    }
}
