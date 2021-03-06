package com.example.keyknowledge.control;

import android.content.Intent;
import com.example.keyknowledge.Knowledge;
import com.example.keyknowledge.Login;
import com.example.keyknowledge.MainActivity;
import com.example.keyknowledge.Pairing;
import com.example.keyknowledge.R;
import com.example.keyknowledge.model.MainManager;
import com.example.keyknowledge.model.User;
import static com.example.keyknowledge.model.Quiz.CLASSIC_MODE;
import static com.example.keyknowledge.model.Quiz.MISC_MODE;
import static com.example.keyknowledge.model.Quiz.RESTART_MODE;


public class MainControl {
    private Intent i;
    private MainActivity main;
    private MainManager manager;
    public MainControl(MainActivity a){
        main=a;
        manager=new MainManager();
    }

    public void setMessage(String x){
        main.message(x);
    }

    public void backHome(String nick){
        manager.accessUser(nick,this);
    }



    public void controlAccess(String nick) {
        System.out.println(nick);
        if(nick!=null){
            backHome(nick);
        }else{
            main.setContent(R.layout.activity_main,null);
        }
    }

    public void setView(int x, User user){
        main.setContent(x,user);
    }

    public void goKnowledge(User user) {
        i=new Intent(main.getApplicationContext(), Knowledge.class);
        i.putExtra("user",user);
        main.startActivity(i);
    }

    public void goLogin(){
        i=new Intent(main.getApplicationContext(), Login.class);
        main.startActivity(i);
    }

    public void logout(User user){
        manager.logout(user);
        i = new Intent(main.getApplicationContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        main.startActivity(i);
    }


    public void searchOpponent(String mode,User user) {
        switch(mode){
            case RESTART_MODE:
                i=new Intent(main.getApplicationContext(), Pairing.class);
                i.putExtra("user",user);
                i.putExtra("mode",mode);
                main.startActivity(i);
                break;
            case MISC_MODE:
            case CLASSIC_MODE:
                main.message("funzione in fase di sviluppo");
                break;

        }
    }
}
