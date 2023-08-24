package com.shesha.mobiledevworkshop.sharedpreferencesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shesha.mobiledevworkshop.sharedpreferencesapp.models.CarEntry;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CarEntry> carEntries;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("CarEntries", MODE_PRIVATE);
        gson = new Gson();

        loadCarEntries();

        EditText etMake = findViewById(R.id.etMake);
        EditText etYear = findViewById(R.id.etYear);
        EditText etModel = findViewById(R.id.etModel);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String make = etMake.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String model = etModel.getText().toString();

                CarEntry carEntry = new CarEntry(make, year, model);
                carEntries.add(carEntry);
                saveCarEntries();
            }
        });
    }

    private void loadCarEntries() {
        String json = sharedPreferences.getString("car_entries", "");
        Type type = new TypeToken<List<CarEntry>>() {}.getType();
        carEntries = gson.fromJson(json, type);
        if (carEntries == null) {
            carEntries = new ArrayList<>();
        }
    }

    private void saveCarEntries() {
        String json = gson.toJson(carEntries);
        sharedPreferences.edit().putString("car_entries", json).apply();
    }
}
