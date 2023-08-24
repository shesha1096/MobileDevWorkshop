package com.shesha.mobiledevworkshop.navigationdrawerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        // Initialize ActionBarDrawerToggle with the DrawerLayout and Toolbar
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                if (item.getItemId() == R.id.nav_item1) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ItemOneFragment())
                            .addToBackStack(null)
                            .commit();
                } else if (item.getItemId() == R.id.nav_item2) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ItemTwoFragment())
                            .addToBackStack(null)
                            .commit();
                }
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });

        if (savedInstanceState == null) {
            // Display the default fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DefaultFragment())
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}