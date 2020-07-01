package com.nicolegongora.progra3_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;
import com.nicolegongora.progra3_proyecto.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        UserRepository userRepository = new UserRepository(MainActivity.this);
        User userLogged= userRepository.getUserLogged();
        if (userLogged!=null){
            Intent toMenu = new Intent(MainActivity.this,MenuActivity.class);
            String userString= new Gson().toJson(userLogged);
            toMenu.putExtra(Constants.INTENT_KEY_USER,userString);
            startActivity(toMenu);
        } else {
            setContentView(R.layout.activity_main);
        }
    }
    public void toSignIn(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void toSignUp(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }



}
