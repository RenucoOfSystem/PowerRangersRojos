package com.nicolegongora.progra3_proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;
import com.nicolegongora.progra3_proyecto.utils.Constants;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    private GoogleApiClient googleApiClient;
    private SignInButton button;


    private LinearLayout backgroundLinearLayout;
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    public static final int SIGN_IN_CODE=1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,  this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        button=(SignInButton)findViewById(R.id.google);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });

        initViews();
        addEvents();
    }

    private void initViews() {
        backgroundLinearLayout= findViewById(R.id.backgroundRL);
        loginButton = findViewById(R.id.loginButton);
        usernameEditText= findViewById(R.id.usernameET);
        passwordEditText=findViewById(R.id.passwordET);

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

                User userInLog= UserRepository.getInstance().login(username,password);
                if (userInLog==null){
                    Toast.makeText(Login.this,getString(R.string.error_entry),Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent menuIntent = new Intent(Login.this,MenuActivity.class);
                String userString= new Gson().toJson(userInLog);
                menuIntent.putExtra(Constants.INTENT_KEY_USER,userString);
                startActivity(menuIntent);




            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==SIGN_IN_CODE)
        {
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            goMainScreen();
        } else {
            Toast.makeText(this,"No",Toast.LENGTH_SHORT).show();
        }
    }

    private void goMainScreen() {
        Intent intent = new Intent(this,MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}


