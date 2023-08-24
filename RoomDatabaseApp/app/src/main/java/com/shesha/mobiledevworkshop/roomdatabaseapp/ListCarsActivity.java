package com.shesha.mobiledevworkshop.roomdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shesha.mobiledevworkshop.roomdatabaseapp.provider.Car;
import com.shesha.mobiledevworkshop.roomdatabaseapp.provider.CarsViewModel;

import java.util.ArrayList;

public class ListCarsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    private Button button;

    ArrayList<Car> db = new ArrayList<>();
    private CarsViewModel mCarsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars);

        Toolbar myToolbar =  findViewById(R.id.list_cars_toolbar);
        myToolbar.setTitle("List of Cars");
        button = findViewById(R.id.delete_car_btn);


        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        mCarsViewModel = new ViewModelProvider(this)
                .get(CarsViewModel.class);
        mCarsViewModel.getAllCars().observe(this, newData -> {
            Toast.makeText(ListCarsActivity.this,"Number of cars: " + newData.size(),Toast.LENGTH_SHORT).show();
            adapter.setNewData(newData);
            adapter.notifyDataSetChanged();
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCarsViewModel.deleteAll();
            }
        });
    }
}