package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

public class FormEmployeeActivity extends AppCompatActivity {
    public static String LOG = FormEmployeeActivity.class.getName();

    private Context context;
    private LinearLayout parentLinearLayout;
    private LinearLayout fullNameLinearLayout;
    private LinearLayout ageCountryLinearLayout;

    private TextView nameTextView;
    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText ageEditText;
    private EditText countryEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmationEditText;
    private TextView passwordTextView;
    private TextView passwordConfirmationTextView;
    private Button acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(render());
    }
    private LinearLayout render(){
        parentLinearLayout = new LinearLayout(context);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //parentLinearLayout.setBackgroundColor(getResources().getDrawable(R.drawable.background)); //Revisar si esta bien
//Agregar lo de la foto y crear el otro formulario
        fullNameLinearLayout = new LinearLayout(context);
        fullNameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        nameEditText = new EditText(context);
        nameEditText.setText("Name");
        fullNameLinearLayout.addView(nameTextView);

        lastNameEditText = new EditText(context);
        lastNameEditText.setText("Lastname");
        fullNameLinearLayout.addView(lastNameEditText);

        parentLinearLayout.addView(fullNameLinearLayout);

        ageCountryLinearLayout = new LinearLayout(context);
        ageCountryLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        ageEditText = new EditText(context);
        ageEditText.setText("Age");
        ageCountryLinearLayout.addView(ageEditText);

        countryEditText = new EditText(context);
        countryEditText.setText("Country");
        ageCountryLinearLayout.addView(countryEditText);

        parentLinearLayout.addView(ageCountryLinearLayout);

        phoneEditText = new EditText(context);
        phoneEditText.setText("Phone");
        parentLinearLayout.addView(phoneEditText);

        emailEditText = new EditText(context);
        //emailEditText.setText("E-mail");
        emailEditText.setHint("E-mail");
        parentLinearLayout.addView(emailEditText);

        passwordTextView = new TextView(context);
        passwordTextView.setText("Password");
        parentLinearLayout.addView(passwordTextView);

        passwordEditText = new EditText(context);
        parentLinearLayout.addView(passwordEditText);

        passwordConfirmationTextView = new TextView(context);
        passwordConfirmationTextView.setText("Password confirmation");
        parentLinearLayout.addView(passwordConfirmationTextView);

        passwordConfirmationEditText = new EditText(context);
        parentLinearLayout.addView(passwordConfirmationEditText);

        acceptButton = new Button(context);
        acceptButton.setText("Accept");
        parentLinearLayout.addView(passwordConfirmationEditText);
        return parentLinearLayout;
    }
}
