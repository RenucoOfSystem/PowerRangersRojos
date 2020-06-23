package com.nicolegongora.progra3_proyecto;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.gson.Gson;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuAdapter;
import com.nicolegongora.progra3_proyecto.adapter.MainMenuEmployeeAdapter;
import com.nicolegongora.progra3_proyecto.model.MainMenuEmployer;
import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;

    public static String LOG = MenuActivity.class.getName();

    private Context context;
    private List<MainMenuEmployer> items2 = new ArrayList<>();
    private List<MainMenuTask> items = new ArrayList<>();
    private User user;

    private MainMenuAdapter adapter;
    private MainMenuEmployeeAdapter adapter2;
    private TextView userTextView;
    private ListView mainMenuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setContentView(R.layout.activity_mainmenulist);
        Log.d(LOG, "onCreate");


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();


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

    private void fillMainMenuWorkerTask() {

        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística", R.drawable.ic_computer, "Cajero nocturno", R.drawable.ic_pencil));
        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística", R.drawable.ic_computer, "Reparador de computadora", R.drawable.ic_pencil));
        items2.add(new MainMenuEmployer(items2.size(), "Electrónica Artística", R.drawable.ic_computer, "Guardia diurno", R.drawable.ic_pencil));

    }


    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {

                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            userTextView = findViewById(R.id.name);
            mainMenuListView = findViewById(R.id.mainMenuListView);
            adapter2 = new MainMenuEmployeeAdapter(context, items2);
            mainMenuListView.setAdapter(adapter2);
            fillMainMenuWorkerTask();
            userTextView.setText(getString(R.string.welcome) + " " + account.getDisplayName());
        } else {
            goLoginScreen();
        }
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this,Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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
        if (user.getType().equals(getString(R.string.employer_button))) {
            adapter2 = new MainMenuEmployeeAdapter(context, items2);
            mainMenuListView.setAdapter(adapter2);
            fillMainMenuWorkerTask();
        } else if (user.getType().equals(getString(R.string.employee_button))) {
            adapter = new MainMenuAdapter(context, items);
            mainMenuListView.setAdapter(adapter);
            fillMainMenuTask();
        }
        userTextView.setText(getString(R.string.welcome) + " " + user.getUsername());

    }

    private void addEvents() {


    }


    private void fillMainMenuTask() {
        items.add(new MainMenuTask(items.size(), "Taller La Concha",
                R.drawable.ic_motor, "Reparador de autos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Pepi Nillo Pizza",
                R.drawable.ic_pizza, "Reparador de hornos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Nola Hiczeaun Motors",
                R.drawable.ic_car, "Revisión de motores",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "School Aritmética",
                R.drawable.ic_escuela, "Reparador de servidores de clases",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));
        items.add(new MainMenuTask(items.size(), "Super Mercado F. Augusto",
                R.drawable.ic_supermarkets, "Revisión de firgoíficos",
                R.drawable.ic_favorite, R.drawable.ic_bookmark, R.drawable.ic_share));

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
