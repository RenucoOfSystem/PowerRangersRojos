package com.nicolegongora.progra3_proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;
import com.nicolegongora.progra3_proyecto.utils.Constants;

public class Login extends AppCompatActivity {
    private LinearLayout backgroundLinearLayout;
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox stayloggedCheckBox;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        addEvents();
    }

    private void initViews() {
        backgroundLinearLayout= findViewById(R.id.backgroundRL);
        loginButton = findViewById(R.id.loginButton);
        usernameEditText= findViewById(R.id.usernameET);
        passwordEditText=findViewById(R.id.passwordET);
        stayloggedCheckBox=findViewById(R.id.stayin);

    }

    private void addEvents() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.isEmpty()){
                    usernameEditText.setError(getString(R.string.error_empty_value,"Username/Usuario"));
                    return;
                }

                if (password.isEmpty()){
                    passwordEditText.setError(getString(R.string.error_empty_value,"Password/Contraseña"));
                    return;
                }

                UserRepository userRepository = new UserRepository(Login.this);
                User userInLog= userRepository.login(username,password);

                if (userInLog==null){
                    Toast.makeText(Login.this,getString(R.string.error_entry),Toast.LENGTH_SHORT).show();
                    return;
                }

                if (stayloggedCheckBox.isChecked()){
                    userRepository.setUserLogged(userInLog);
                }

                Intent menuIntent = new Intent(Login.this,MenuActivity.class);
                String userString= new Gson().toJson(userInLog);
                menuIntent.putExtra(Constants.INTENT_KEY_USER,userString);
                startActivity(menuIntent);


            }
        });
    }

}


