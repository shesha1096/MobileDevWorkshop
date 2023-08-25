package com.shesha.mobiledevworkshop.userinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.shesha.mobiledevworkshop.userinfoapp.provider.User;
import com.shesha.mobiledevworkshop.userinfoapp.provider.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListUsersActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private List<String> userNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        userNames = new ArrayList<>();
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, users -> {
            for (User user : users) {
                userNames.add(user.getUserName());
            }
            Toast.makeText(ListUsersActivity.this, userNames.toString(), Toast.LENGTH_LONG).show();
        });
    }
}