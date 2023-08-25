package com.shesha.mobiledevworkshop.userinfoapp.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    UserRepository(Application application) {
        UserDatabase userDatabase = UserDatabase.getDatabase(application);
        userDao = userDatabase.userDao();
        allUsers = userDao.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    void insertUser(User user) {
        UserDatabase.databaseWriteExecutor.execute(() -> userDao.insertUser(user));
    }
}
