package com.nicolegongora.progra3_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
