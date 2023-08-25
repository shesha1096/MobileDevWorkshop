package com.shesha.mobiledevworkshop.userinfoapp.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select * from user")
    LiveData<List<User>> getAllUsers();

    @Query("delete from user where user_name = :userName")
    void deleteUserByUsername(String userName);

    @Query("update user set user_name = :newUsername where id = :id")
    void updateUserName(String newUsername, int id);
}
