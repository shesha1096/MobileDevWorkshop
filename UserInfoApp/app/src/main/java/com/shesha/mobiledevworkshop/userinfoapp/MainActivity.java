package com.shesha.mobiledevworkshop.userinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shesha.mobiledevworkshop.userinfoapp.provider.User;
import com.shesha.mobiledevworkshop.userinfoapp.provider.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText emailInput;
    private Button submitButton;

    private Button listAllUsersButton;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.username_input);
        emailInput = findViewById(R.id.user_email_input);
        submitButton = findViewById(R.id.add_user_btn);
        listAllUsersButton = findViewById(R.id.list_all_user_btn);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserEmail(emailInput.getText().toString());
                user.setUserName(usernameInput.getText().toString());
                userViewModel.insertUser(user);
                Toast.makeText(MainActivity.this, "New User added", Toast.LENGTH_LONG).show();
            }
        });

        listAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListUsersActivity.class);
                startActivity(intent);
            }
        });
    }
}