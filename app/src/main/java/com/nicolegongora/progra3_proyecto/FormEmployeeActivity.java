package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;

public class FormEmployeeActivity extends AppCompatActivity{


    private String country="";

    private Context context;
    private LinearLayout parentLinearLayout;
    private LinearLayout fullNameLinearLayout;
    private LinearLayout ageCountryLinearLayout;

    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText ageEditText;
    private Spinner countrySpinner;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmationEditText;
    private TextView passwordTextView;
    private TextView passwordConfirmationTextView;
    private Button acceptButton;
    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(render());
        addEvents();
    }


    private View render(){
        parentLinearLayout = new LinearLayout(context);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        parentLinearLayout.setBackground(getResources().getDrawable(R.drawable.background)); //Revisar si esta bien
//Agregar lo de la foto y crear el otro formulario
        fullNameLinearLayout = new LinearLayout(context);
        fullNameLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        nameEditText = new EditText(context);
        nameEditText.setText("Name");
        fullNameLinearLayout.addView(nameEditText);

        lastNameEditText = new EditText(context);
        lastNameEditText.setText("Last name");
        fullNameLinearLayout.addView(lastNameEditText);

        parentLinearLayout.addView(fullNameLinearLayout);

        usernameEditText = new EditText(context);
        usernameEditText.setText("Username");
        parentLinearLayout.addView(usernameEditText);

        ageCountryLinearLayout = new LinearLayout(context);
        ageCountryLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        ageEditText = new EditText(context);
        ageEditText.setText("Age");
        ageCountryLinearLayout.addView(ageEditText);

        countrySpinner = new Spinner(context);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.countries,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);
        ageCountryLinearLayout.addView(countrySpinner);

        parentLinearLayout.addView(ageCountryLinearLayout);

        phoneEditText = new EditText(context);
        phoneEditText.setText("Phone");
        parentLinearLayout.addView(phoneEditText);

        emailEditText = new EditText(context);
        emailEditText.setText("E-mail");
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

    private void addEvents(){
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameEditText.getText().toString().trim();
                String lastname= lastNameEditText.getText().toString().trim();
                String password= passwordEditText.getText().toString().trim();
                String passwordconfirmate= passwordConfirmationEditText.getText().toString().trim();
                String email =  emailEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String age= ageEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();

                countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        country= adapterView.getItemAtPosition(position).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                if (name.isEmpty() || lastname.isEmpty()){
                    Toast.makeText(context,getString(R.string.error_empty_value,"Names/Nombres"),Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()){
                    Toast.makeText(context,getString(R.string.error_empty_value,"Password/Contraseña"),Toast.LENGTH_SHORT).show();
                    return;
                }

                if(passwordconfirmate.isEmpty() || !passwordconfirmate.equals(password)){
                    Toast.makeText(context,getString(R.string.error_pasword),Toast.LENGTH_SHORT).show();
                }


                if (username.isEmpty()){
                    Toast.makeText(context,getString(R.string.error_empty_value,"Username/Nombre de usuario"),Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty()){
                    Toast.makeText(context,getString(R.string.error_empty_value,"Email"),Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!(phone.length()==8 && !phone.contains(" "))){
                    Toast.makeText(context,getString(R.string.error_invalid_value,"Phone number/Teléfono"),Toast.LENGTH_SHORT).show();
                    return;
                }

                int phoneNumber = 0;
                try {
                    phoneNumber = Integer.parseInt(phone);
                } catch (Exception ex) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_value,"Phone number/Teléfono"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                if (Integer.parseInt(age)<18 || age.contains(" ")){

                    Toast.makeText(context,getString(R.string.error_invalid_value,"Age/Edad"),Toast.LENGTH_SHORT).show();
                    return;
                }

                int aGe = 0;
                try {
                    aGe = Integer.parseInt(age);
                } catch (Exception ex) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_value,"Age/Edad"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                User user= new User(name,username,password,email,country,phoneNumber,aGe);
                user.setType("Employee");
                UserRepository.getInstance().register(user);
                finish();
            }
        });
    }


}
