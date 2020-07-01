package com.nicolegongora.progra3_proyecto;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.MemoryFile;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuAdapter;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuEmployeeAdapter;
import com.nicolegongora.progra3_proyecto.model.MainMenuEmployer;
import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;
import com.nicolegongora.progra3_proyecto.repository.local.MenuRepositoryEmployee;
import com.nicolegongora.progra3_proyecto.repository.local.db.MenuDb;
import com.nicolegongora.progra3_proyecto.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    public static String LOG = MenuActivity.class.getName();

    private Context context;
    private List<MainMenuTask> items = new ArrayList<>();
    private User user;

    private boolean userclicked = false;
    private MainMenuAdapter adapter;
    private TextView userTextView;
    private ListView mainMenuListView;
    private Button favoButton;
    private Button logoutButton;

    private MenuRepositoryEmployee menuDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        menuDb= new MenuRepositoryEmployee(getApplication());
        setContentView(R.layout.activity_mainmenulist);
        Log.d(LOG, "onCreate");

        receiveValues();
        initViews();
        addEvents();
        fillMainMenuTask(1);

        menuDb.getAll().observe(this, new Observer<List<MainMenuTask>>() {
            @Override
            public void onChanged(List<MainMenuTask> mainMenuTasks) {
                items=mainMenuTasks;

                adapter.setItems(mainMenuTasks);
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void receiveValues() {
        Intent intent = getIntent();

        if (intent.hasExtra(Constants.INTENT_KEY_USER)) {

            String userObj = intent.getStringExtra(Constants.INTENT_KEY_USER);

            user = new Gson().fromJson(userObj, User.class);

        }

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
        userTextView = findViewById(R.id.name);
        mainMenuListView = findViewById(R.id.mainMenuListView);
        favoButton=findViewById(R.id.favoriteButton);
        logoutButton=findViewById(R.id.logOut);
        userTextView.setText(getString(R.string.welcome) + ", " +  user.getUsername() + " (" + user.getName() + " ) ");
        adapter=new MainMenuAdapter(context,items);
        mainMenuListView.setAdapter(adapter);

    }

    private void addEvents() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuDb.deleteAll();
                UserRepository userRepository= new UserRepository(context);
                userRepository.deleteUserLogged();

                Intent intent = new Intent(context,SplashScreen.class);
                startActivity(intent);

            }
        });
        mainMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainMenuTask task= items.get(position);
                Intent detailsIntent= new Intent(context,WorkScreenActivity.class);
                detailsIntent.putExtra("id",task.getId());
                startActivity(detailsIntent);
            }
        });


        favoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.clear();
                fillMainMenuTask(0);

            }
        });



    }



    private void fillMainMenuTask(int op) {
        items.add(new MainMenuTask("Reparador de computadoras", "Pablo Alvarado", R.drawable.ic_computer, "Experiencia en software Windows 10", 68141001, "geo:0,0?q=-16.508285, -68.126612", "Pizza mía"));
        items.add(new MainMenuTask("Profesor de Matemáticas", "Ena Arkea", R.drawable.ic_escuela, "Experiencia con temas de 4to a 6to de Primaria", 68141001, "geo:0,0?q=-16.506470, -68.118500", "Colegio Santa María"));
        items.add(new MainMenuTask("Mecánico", "Victoria Millan", R.drawable.ic_car, "Conocimiento de motores Honda y Suzuki", 68141001, "geo:0,0?q=-16.509926, -68.118704", "Taller el Nico"));
        items.add(new MainMenuTask("Delivery", "Pablo Alvarado", R.drawable.ic_motorcycle, "Mayor de 19 años, licencia de conducir y experiencia con motocicletas", 68141001, "geo:0,0?q=-16.508285, -68.126612", "Pizza mía"));

        if (op==1) {
            for (MainMenuTask tasks : items) {
                menuDb.insert(tasks);
            }
        } else {
            for (MainMenuTask tasks : items){
                menuDb.getFavo().observe(this, new Observer<List<MainMenuTask>>() {
                    @Override
                    public void onChanged(List<MainMenuTask> mainMenuTasks) {
                        items=mainMenuTasks;

                        adapter.setItems(mainMenuTasks);
                        adapter.notifyDataSetChanged();
                        userTextView.setText(getString(R.string.to_favorites));
                        favoButton.setText(getString(R.string.all_works));
                    }
                });
            }
        }
    }

}