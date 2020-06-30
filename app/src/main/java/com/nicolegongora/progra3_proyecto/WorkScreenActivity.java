package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WorkScreenActivity extends AppCompatActivity {
    private static final String LOG = WorkScreenActivity.class.getSimpleName();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_screen);
        context = this;
        addEvents();
    }

    private void addEvents() {
    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "68224194"));
        startActivity(intent);

    }

    //cambiar a un lugar mas bonito
    public void map(View view){
        String name = "Lugar del trabajo";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,07q=-10.32431, -40.123456 (" + name + " )"));
        startActivity(intent);


    }

}
