package com.noname.fastmoney.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.noname.fastmoney.App;
import com.noname.fastmoney.data.dao.UserDao;
import com.noname.fastmoney.data.database.AppDatabase;
import com.noname.fastmoney.data.entities.CatalogItems;
import com.noname.fastmoney.data.entities.User;
import com.noname.fastmoney.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        AppDatabase db = App.getInstance().getDatabase();
        userDao = db.mUserDao();
        setTitle("Добро пожаловать!");
        checkAuth();

        mBinding.btnAuthorization.setOnClickListener(view -> {

            startActivity(new Intent(this, CatalogActivity.class));


        });
    }

    private void checkAuth() {
        User user = userDao.getUserById(1);

        if (user.auth != 0) {
            startActivity(new Intent(this, CatalogActivity.class));
            finish();
        }
    }
}