package com.shesha.mobiledevworkshop.workshoptwoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shesha.mobiledevworkshop.workshoptwoapp.adapter.MovieAdapter;
import com.shesha.mobiledevworkshop.workshoptwoapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initMovies();
        MovieAdapter movieAdapter = new MovieAdapter(movies);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initMovies() {
        for (int i = 0; i < 10; i++) {
            movies.add(new Movie("Movie " + (i+1), "Description " + (i+1)));
        }
    }
}