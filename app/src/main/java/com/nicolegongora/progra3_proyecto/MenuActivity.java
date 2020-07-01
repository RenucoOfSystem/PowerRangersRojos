package com.nicolegongora.progra3_proyecto;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuAdapter;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuEmployeeAdapter;
import com.nicolegongora.progra3_proyecto.model.MainMenuEmployer;
import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;
import com.nicolegongora.progra3_proyecto.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    public static String LOG = MenuActivity.class.getName();

    private Context context;
    private List<MainMenuEmployer> items2 = new ArrayList<>();
    private List<MainMenuTask> items = new ArrayList<>();
    private User user;

    private MainMenuAdapter adapter;
    private MainMenuEmployeeAdapter adapter2;
    private TextView userTextView;
    private ListView mainMenuListView;
    private Button favoButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_mainmenulist);
        Log.d(LOG, "onCreate");


        receiveValues();
        initViews();
        addEvents();
    }

    private void receiveValues() {
        Intent intent = getIntent();

        if (intent.hasExtra(Constants.INTENT_KEY_USER)) {

            String userObj = intent.getStringExtra(Constants.INTENT_KEY_USER);

            user = new Gson().fromJson(userObj, User.class);

        }

    }

  //falta unir
    private void fillMainMenuWorkerTask() {

        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística",
                R.drawable.ic_computer, "Cajero nocturno", R.drawable.ic_pencil));
        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística",
                R.drawable.ic_computer, "Reparador de computadora", R.drawable.ic_pencil));
        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística",
                R.drawable.ic_computer, "Guardia diurno", R.drawable.ic_pencil));

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
        userTextView.setText(R.string.welcome + ", " +  user.getUsername() + " (" + user.getName() + " ) ");

    }

    private void addEvents() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRepository userRepository= new UserRepository(context);
                userRepository.deleteUserLogged();
                finish();
            }
        });

    }

    public void share(View view){

        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        String message = "Te recomiendo este trabajo";
        share.putExtra(android.content.Intent.EXTRA_SUBJECT, "empleos Baja App");
        share.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(share, "Compartir vía"));

    }


    private void fillMainMenuTask() {
        items.add(new MainMenuTask( "Taller La Concha",
                R.drawable.ic_motor, "Reparador de autos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask( "Pepi Nillo Pizza",
                R.drawable.ic_pizza, "Reparador de hornos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask("Nola Hiczeaun Motors",
                R.drawable.ic_car, "Revisión de motores",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask( "School Aritmética",
                R.drawable.ic_escuela, "Reparador de servidores de clases",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask( "Super Mercado F. Augusto",
                R.drawable.ic_supermarkets, "Revisión de firgoíficos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));

    }

}