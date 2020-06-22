package com.nicolegongora.progra3_proyecto;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nicolegongora.progra3_proyecto.adapter.MainMenuAdapter;
import com.nicolegongora.progra3_proyecto.model.MainMenuTask;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    public static String LOG = MenuActivity.class.getName();

    private Context context;
    private List<MainMenuTask> items = new ArrayList<>();


    private MainMenuAdapter adapter;
    private ListView mainMenuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_mainmenu);
        Log.d(LOG, "onCreate");

        initViews();
        addEvents();
        fillMainMenuTask();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "onDestroy");
    }


    private void initViews() {
        mainMenuListView =  findViewById(R.id.mainMenuListView);
        adapter = new MainMenuAdapter(context, items);
        mainMenuListView.setAdapter(adapter);

    }

    private void addEvents() {

    }


    private void fillMainMenuTask() {
        items.add(new MainMenuTask(items.size(), "Juan Chovilla",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Pepi Nillo",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Nola Hiczeaun",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Komoseyama",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Super F. Augusto",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Juan Chovilla2",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Juan Chovilla3",
                R.drawable.ic_refresh, "Description",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
    }

    }
