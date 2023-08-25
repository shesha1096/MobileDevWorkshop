package com.shesha.mobiledevworkshop.retrofitworkshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shesha.mobiledevworkshop.retrofitworkshopapp.repository.APIClient;
import com.shesha.mobiledevworkshop.retrofitworkshopapp.repository.APIInterface;
import com.shesha.mobiledevworkshop.retrofitworkshopapp.repository.User;
import com.shesha.mobiledevworkshop.retrofitworkshopapp.repository.UserList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private APIInterface apiInterface;

    private Button addUserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.response_text);
        addUserButton = findViewById(R.id.add_user_btn);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        getListOfUsers("1");
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void getListOfUsers(String pageNumber) {
        Call<UserList> userListCall = apiInterface.doGetUserList(pageNumber);
        userListCall.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                Toast.makeText(MainActivity.this, "Number of users: " + userList.total, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get data: ", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addUser() {
        User user = new User("Shesha","App Dev");
        Call<User> createUserCall = apiInterface.createUser(user);
        createUserCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int responseCode = response.code();
                User newUser = response.body();
                Toast.makeText(MainActivity.this, "Response Code: " + responseCode, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to get data: ", Toast.LENGTH_LONG).show();
            }
        });
    }
}