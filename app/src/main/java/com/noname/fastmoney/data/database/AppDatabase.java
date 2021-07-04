package com.noname.fastmoney.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.noname.fastmoney.data.dao.UserDao;
import com.noname.fastmoney.data.entities.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao mUserDao();
}
