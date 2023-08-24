package com.shesha.mobiledevworkshop.carmakerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shesha.mobiledevworkshop.carmakerapp.model.CarEntry;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText yearText;
    private EditText modelText;
    private EditText companyText;
    private Button addCarButton;
    private String yearString;
    private String modelString;
    private String companyString;

    private List<CarEntry> carEntries;
    private Gson gson;

    private TextView carEntriesTextView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("CarEntries",MODE_PRIVATE);

        gson = new Gson();
        loadCarEntries();

        yearText = findViewById(R.id.year_input);
        modelText = findViewById(R.id.model_input);
        companyText = findViewById(R.id.company_input);
        addCarButton = findViewById(R.id.save_car_btn);
        carEntriesTextView = findViewById(R.id.car_entries);

        yearText.setText(yearString);
        modelText.setText(modelString);
        companyText.setText(companyString);

        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yearString = yearText.getText().toString();
                modelString = modelText.getText().toString();
                companyString = companyText.getText().toString();
                CarEntry carEntry = new CarEntry(companyString, modelString, yearString);
                carEntries.add(carEntry);
                saveCarEntries();
                Toast.makeText(MainActivity.this,"Car Saved",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadCarEntries() {
        String json = sharedPreferences.getString("car_entries", "");
        Type type = new TypeToken<List<CarEntry>>(){}.getType();
        carEntries = gson.fromJson(json, type);
        if (carEntries == null) {
            carEntries = new ArrayList<>();

        } else {
            carEntriesTextView.setText(gson.toJson(carEntries));
        }

    }

    private void saveCarEntries() {
        String json = gson.toJson(carEntries);
        sharedPreferences.edit().putString("car_entries",json).apply();
        carEntriesTextView.setText(json);
    }
}