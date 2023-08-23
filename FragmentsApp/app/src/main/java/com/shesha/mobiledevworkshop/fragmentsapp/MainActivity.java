package com.shesha.mobiledevworkshop.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container,new ListFragment())
                    .commit();
        }
    }


    @Override
    public void onItemClick(String selectedItem) {
        ItemListFragment detailsFragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putString("title", selectedItem);
        detailsFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, detailsFragment)
                .addToBackStack(null)
                .commit();
    }
}