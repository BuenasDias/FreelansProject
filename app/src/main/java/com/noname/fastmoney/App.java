package com.noname.fastmoney;

import android.app.Application;

import androidx.room.Room;

import com.noname.fastmoney.data.database.AppDatabase;
import com.noname.fastmoney.data.entities.User;
import com.onesignal.OneSignal;

public class App extends Application {

    public static App instance;
    private static final String ONESIGNAL_APP_ID = "7a9d5638-813f-4ed6-8cbe-5a0f44b91182";

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

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
