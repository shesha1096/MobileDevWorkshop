package com.shesha.mobiledevworkshop.formapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class MainActivity extends AppCompatActivity {
    private EditText emailInput;
    private EditText passwordTextInput;
    private EditText passwordReEntryTextInput;
    private Spinner genderSelectionInput;
    private Switch updatesPreference;
    private Button submitButton;
    String[] genderDropDownDetails = {"Male", "Female", "Prefer Not To Say"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailInput = findViewById(R.id.email_input);
        passwordTextInput = findViewById(R.id.password_input);
        passwordReEntryTextInput = findViewById(R.id.re_enter_password);
        genderSelectionInput = findViewById(R.id.gender_dropdown);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, genderDropDownDetails);
        genderSelectionInput.setAdapter(genderAdapter);
        updatesPreference = findViewById(R.id.updates_switch);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        updatesPreference.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    updatesPreference.setText(getString(R.string.yes));
                } else {
                    updatesPreference.setText(getString(R.string.no));
                }
            }
        });
    }
}