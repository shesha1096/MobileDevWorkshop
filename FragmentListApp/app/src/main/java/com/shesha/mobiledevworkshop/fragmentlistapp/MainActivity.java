package com.shesha.mobiledevworkshop.fragmentlistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, new ListFragment())
                .commit();

    }

    @Override
    public void onItemClick(String selectedItem) {
        Bundle arguments = new Bundle();
        arguments.putString("item",selectedItem);

        ItemListFragment itemListFragment = new ItemListFragment();
        itemListFragment.setArguments(arguments);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, itemListFragment)
                .addToBackStack(null)
                .commit();

    }
}