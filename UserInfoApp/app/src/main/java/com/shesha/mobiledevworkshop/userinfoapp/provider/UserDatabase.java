package com.shesha.mobiledevworkshop.userinfoapp.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "user_database";
    public abstract UserDao userDao();

    private static volatile UserDatabase userDatabase;
    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UserDatabase getDatabase(final Context context) {
        if (userDatabase == null) {
            synchronized (UserDatabase.class) {
                userDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        UserDatabase.class, DATABASE_NAME)
                        .build();
            }
        }
        return userDatabase;
    }
}
