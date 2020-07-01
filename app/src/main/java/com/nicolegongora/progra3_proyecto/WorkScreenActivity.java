package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.nicolegongora.progra3_proyecto.model.MainMenuTask;
import com.nicolegongora.progra3_proyecto.repository.local.MenuRepositoryEmployee;

public class WorkScreenActivity extends AppCompatActivity {
    private static final String LOG = WorkScreenActivity.class.getSimpleName();
    private Context context;
    private ImageView icon;
    private TextView employer;
    private TextView descript;
    private TextView corp;
    private TextView title;
    private Button applied;

    private MainMenuTask taskselected;
    private MenuRepositoryEmployee menuRepositoryEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_work_screen);

        menuRepositoryEmployee= new MenuRepositoryEmployee(getApplication());
        initViews();
        addEvents();

        Intent intent = getIntent();
        if (intent.hasExtra("id")){
            long id = intent.getLongExtra("id",0);
            menuRepositoryEmployee.getById(id).observe(this, new Observer<MainMenuTask>() {
                @Override
                public void onChanged(MainMenuTask mainMenuTask) {
                    taskselected=mainMenuTask;
                    icon.setImageResource(mainMenuTask.getImage());
                    title.setText(mainMenuTask.getTitle());
                    employer.setText(mainMenuTask.getName());
                    descript.setText(mainMenuTask.getDescription());
                    corp.setText(mainMenuTask.getCorporate());
                    if (mainMenuTask.isFavorite()){
                        applied.setText(getString(R.string.inscri));
                    } else {
                        applied.setText(getString(R.string.apply_now));
                    }
                }
            });
        }
    }

    private void initViews() {
        icon=findViewById(R.id.work_image);
        title=findViewById(R.id.work_title);
        descript=findViewById(R.id.work_how);
        corp=findViewById(R.id.work_where);
        employer=findViewById(R.id.work_creator);
        applied=findViewById(R.id.applied);
    }

    private void addEvents() {
        applied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskselected.setFavorite(!taskselected.isFavorite());
                menuRepositoryEmployee.updateEntry(taskselected);
            }
        });

    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + taskselected.getTelephone()));
        startActivity(intent);

    }

    //cambiar a un lugar mas bonito
    public void map(View view){
        String name = taskselected.getCorporate();
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(taskselected.getMap()+" (" + name + " )"));
        startActivity(intent);


    }

}
