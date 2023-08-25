package com.shesha.mobiledevworkshop.userinfoapp.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();

    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }
}
