package com.nicolegongora.progra3_proyecto;

import android.content.Context;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nicolegongora.progra3_proyecto.model.User;
import com.nicolegongora.progra3_proyecto.repository.UserRepository;

public class FormEmployeeActivity extends AppCompatActivity{


    private String country="";

    private Context context;
    private LinearLayout parentLinearLayout;

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
    private TextView emailTextView;
    private TextView ageTextView;
    private TextView phoneTextView;
    private Button acceptButton;
    private EditText usernameEditText;
    private LinearLayout ageLinearLayout;
    private TextView countryTextView;
    private TextView nameTextView;
    private TextView lastNameTextView;
    private TextView usernameTextView;
    private ScrollView scroller;
    private LinearLayout realparentLinearLayout;
    private TextView abiilitiesTextView;
    private EditText abilitiesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(render());
        addEvents();
    }


    private View render(){

        realparentLinearLayout = new LinearLayout(context);
        realparentLinearLayout.setBackground(getResources().getDrawable(R.drawable.background));
        realparentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        realparentLinearLayout.setPadding(50,50,50,50);
//Agregar lo de la foto

        scroller=new ScrollView(context);


        parentLinearLayout= new LinearLayout(context);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        parentLinearLayout.setBackground(getResources().getDrawable(R.drawable.style_form_login));
        parentLinearLayout.setPadding(50,50,50,50);


        nameTextView= new TextView(context);
        nameTextView.setText(getString(R.string.nameField));
        parentLinearLayout.addView(nameTextView);
        nameEditText = new EditText(context);
        parentLinearLayout.addView(nameEditText);


        lastNameTextView = new TextView(context);
        lastNameTextView.setText(getString(R.string.lastNameField));
        parentLinearLayout.addView(lastNameTextView);
        lastNameEditText = new EditText(context);
        parentLinearLayout.addView(lastNameEditText);


        usernameTextView = new TextView(context);
        usernameTextView.setText(getString(R.string.username));
        parentLinearLayout.addView(usernameTextView);
        usernameEditText = new EditText(context);

        parentLinearLayout.addView(usernameEditText);


        ageTextView= new TextView(context);
        ageTextView.setText(getString(R.string.ageField));
        parentLinearLayout.addView(ageTextView);
        ageEditText = new EditText(context);
        parentLinearLayout.addView(ageEditText);


        countryTextView= new TextView(context);
        countryTextView.setText(getString(R.string.countryField));
        parentLinearLayout.addView(countryTextView);

        countrySpinner = new Spinner(context);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.countries,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);
        parentLinearLayout.addView(countrySpinner);

        phoneTextView = new TextView(context);
        phoneTextView.setText(getString(R.string.phoneField));
        parentLinearLayout.addView(phoneTextView);
        phoneEditText = new EditText(context);
        parentLinearLayout.addView(phoneEditText);


        emailTextView = new TextView(context);
        emailTextView.setText(getString(R.string.emailField));
        parentLinearLayout.addView(emailTextView);
        emailEditText = new EditText(context);
        parentLinearLayout.addView(emailEditText);

        passwordTextView = new TextView(context);
        passwordTextView.setText(getString(R.string.password_indicator));
        parentLinearLayout.addView(passwordTextView);
        passwordEditText = new EditText(context);
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        parentLinearLayout.addView(passwordEditText);

        passwordConfirmationTextView = new TextView(context);
        passwordConfirmationTextView.setText(getString(R.string.passwordConfirm));
        parentLinearLayout.addView(passwordConfirmationTextView);
        passwordConfirmationEditText = new EditText(context);
        passwordConfirmationEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        parentLinearLayout.addView(passwordConfirmationEditText);

        abiilitiesTextView = new TextView(context);
        abiilitiesTextView.setText(getString(R.string.abilitiesField));
        parentLinearLayout.addView(abiilitiesTextView);
        abilitiesEditText = new EditText(context);
        parentLinearLayout.addView(abilitiesEditText);



        acceptButton = new Button(context);
        acceptButton.setText(getString(R.string.register_indicator));
        acceptButton.setBackgroundResource(R.color.colorAccent);
        acceptButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        parentLinearLayout.addView(acceptButton);

        scroller.addView(parentLinearLayout);
        realparentLinearLayout.addView(scroller);

        return realparentLinearLayout;
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
                String ability= abilitiesEditText.getText().toString().trim();

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
                user.setType(getString(R.string.employee_button));
                user.setAbility(ability);
                UserRepository.getInstance().register(user);
                finish();
            }
        });
    }




}
