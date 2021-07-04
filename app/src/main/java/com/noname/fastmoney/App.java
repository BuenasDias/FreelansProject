package com.noname.fastmoney;

import android.app.Application;

import androidx.room.Room;

import com.noname.fastmoney.data.database.AppDatabase;
import com.noname.fastmoney.data.entities.User;

public class App extends Application {

    public static App instance;

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        if (mDatabase.mUserDao().getUserById(1) == null) {

            User user = new User();
            user.id = 1;
            user.auth = 0;
            user.name = "test";
            user.phone = "test";

            mDatabase.mUserDao().insertUser(user);
        }
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }
}