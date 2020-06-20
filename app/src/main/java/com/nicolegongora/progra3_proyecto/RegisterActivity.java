package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nicolegongora.progra3_proyecto.adapter.OptionAdapter;
import com.nicolegongora.progra3_proyecto.model.RegisButton;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Context context;
    private OptionAdapter adapter;

    private ListView optionListView;
    private List<RegisButton> regBut= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_typeofregister);

        initViews();
        addEvents();
        fillOptions();

    }

    private void initViews() {
        optionListView = findViewById(R.id.optionListView);
        adapter=new OptionAdapter(context,regBut);
        optionListView.setAdapter(adapter);
    }

    private void addEvents() {

    }

    private void fillOptions() {
        regBut.add(new RegisButton(regBut.size(),getString(R.string.employer_button),R.drawable.ic_employer));
        regBut.add(new RegisButton(regBut.size(),getString(R.string.employee_button),R.drawable.ic_employee));

    }

}
