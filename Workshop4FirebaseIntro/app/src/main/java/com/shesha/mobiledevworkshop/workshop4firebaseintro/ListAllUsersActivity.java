package com.shesha.mobiledevworkshop.workshop4firebaseintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListAllUsersActivity extends AppCompatActivity {

    private ListView allUsersListView;
    private ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_users);
        allUsersListView = findViewById(R.id.list_all_users);
        users = new ArrayList<>();
        if (getIntent().getExtras() != null) {
            users = getIntent().getStringArrayListExtra("users");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListAllUsersActivity.this, android.R.layout.simple_list_item_1,users);
        allUsersListView.setAdapter(arrayAdapter);
    }
}