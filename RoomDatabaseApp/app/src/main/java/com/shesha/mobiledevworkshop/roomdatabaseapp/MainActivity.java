package com.shesha.mobiledevworkshop.roomdatabaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.shesha.mobiledevworkshop.roomdatabaseapp.provider.Car;
import com.shesha.mobiledevworkshop.roomdatabaseapp.provider.CarsViewModel;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText makerTv;
    EditText modelTv;
    EditText yearTv;
    EditText coloTv;
    EditText seatsTv;
    EditText priceTv;

    ArrayList<String> fleet = new ArrayList<>();
    ArrayAdapter<String> adapter;
    DrawerLayout drawer;
    Gson gson = new Gson();
    ArrayList<Car> db = new ArrayList<>();

    SharedPreferences sP;

    private CarsViewModel mCarsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ListView fleetListView = findViewById(R.id.cars_list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fleet);
        fleetListView.setAdapter(adapter);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS, android.Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);

        makerTv = findViewById(R.id.maker_id);
        modelTv = findViewById(R.id.model_id);
        yearTv = findViewById(R.id.year_id);
        coloTv = findViewById(R.id.color_id);
        seatsTv = findViewById(R.id.seats_id);
        priceTv = findViewById(R.id.price_id);


        SharedPreferences sP = getPreferences(0);
        makerTv.setText(sP.getString(getString(R.string.MAKER_KEY), ""));
        modelTv.setText(sP.getString(getString(R.string.MODEL_KEY), ""));
        yearTv.setText(Integer.toString(sP.getInt(getString(R.string.YEAR_KEY), 2021)));
        coloTv.setText(sP.getString(getString(R.string.COLOR_KEY), ""));
        seatsTv.setText(Integer.toString(sP.getInt(getString(R.string.SEATS_KEY), 4)));
        priceTv.setText(Float.toString(sP.getFloat(getString(R.string.PRICE_KEY), 0)));

        FloatingActionButton fab = findViewById(R.id.fab_add_car);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCar();
            }
        });

        mCarsViewModel = new ViewModelProvider(this).get(CarsViewModel.class);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void saveCar() {
        String maker = makerTv.getText().toString();
        String model = modelTv.getText().toString();
        int year = Integer.parseInt(yearTv.getText().toString());
        String color = coloTv.getText().toString();
        int seats = Integer.parseInt(seatsTv.getText().toString());
        float price = Float.parseFloat(priceTv.getText().toString());

        Toast.makeText(this, "A new car from " + maker + " added", Toast.LENGTH_SHORT).show();

        Car newCar = new Car(
                maker,
                model,
                year,
                color,
                seats,
                price);

        mCarsViewModel.insert(newCar);

    }
    private void updateUI(String maker, String model, int year, String color, int seats, float price) {
        makerTv.setText(maker);
        modelTv.setText(model);
        yearTv.setText(Integer.toString(year));
        coloTv.setText(color);
        seatsTv.setText(Integer.toString(seats));
        priceTv.setText(Float.toString(price));
    }

    void clearFleet() {
        mCarsViewModel.deleteAll();
        adapter.notifyDataSetChanged();
    }

    void removeLastCarAdded() {
        if (fleet.size() > 0)
            fleet.remove(fleet.size() - 1);
        adapter.notifyDataSetChanged();
    }

    private void clearFields() {
        makerTv.setText("");
        modelTv.setText("");
        yearTv.setText(Integer.toString(0));
        coloTv.setText("");
        seatsTv.setText(Integer.toString(0));
        priceTv.setText(Float.toString(0));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == R.id.add_car_drawer) {
            saveCar();
        } else if (item.getItemId() == R.id.remove_last_car_drawer) {
            removeLastCarAdded();
        } else if (item.getItemId() == R.id.remove_all_cars_drawer) {
            clearFleet();
        } else if (item.getItemId() == R.id.list_all_cars) {
            Intent intent = new Intent(getApplicationContext(), ListCarsActivity.class);
            startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == R.id.clear_fields_drawer) {
            clearFields();
        }
        return true;
    }

}