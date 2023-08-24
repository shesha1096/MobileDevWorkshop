package com.shesha.mobiledevworkshop.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout container;

    private Button firstFragmentButton;

    private Button secondFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.host_container);
        firstFragmentButton = findViewById(R.id.first_fragment_btn);
        secondFragmentButton = findViewById(R.id.second_fragment_btn);
        firstFragmentButton.setOnClickListener(this);
        secondFragmentButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.first_fragment_btn) {
            //Step 1: Getting a reference for Fragment Manager
            FragmentManager fragmentManager = getSupportFragmentManager();

            //Step 2: Create a new transaction, inflate the fragment, commit the transaction.
            fragmentManager.beginTransaction().replace(R.id.host_container, new FirstFragment())
                    .commit();
        } else if (view.getId() == R.id.second_fragment_btn) {
            //Step 1: Getting a reference for Fragment Manager
            FragmentManager fragmentManager = getSupportFragmentManager();

            //Step 2: Create a new transaction, inflate the fragment, commit the transaction.
            fragmentManager.beginTransaction().replace(R.id.host_container, new SecondFragment())
                    .commit();
        }
    }
}