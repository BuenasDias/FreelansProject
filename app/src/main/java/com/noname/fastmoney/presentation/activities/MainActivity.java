package com.noname.fastmoney.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.noname.fastmoney.App;
import com.noname.fastmoney.api.network.apiClient.ApiClient;
import com.noname.fastmoney.api.requests.auth.Response;
import com.noname.fastmoney.data.dao.UserDao;
import com.noname.fastmoney.data.database.AppDatabase;
import com.noname.fastmoney.data.entities.User;
import com.noname.fastmoney.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;

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

            ApiClient.getInstance()
                    .getApiService()
                    .sendSms(mBinding.userPhone.getText().toString(), generateCode())
                    .enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {

                            // TODO обработать ответ от сервера

                        }

                        @Override
                        public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {
                            t.printStackTrace();
                        }
                    });

//            startActivity(new Intent(this, CatalogActivity.class));


        });
    }

    // Generate #### number
    private int generateCode() {
        return (int) (Math.random() * 10000);
    }

    private void checkAuth() {
        User user = userDao.getUserById(1);

        if (user.auth != 0) {
            startActivity(new Intent(this, CatalogActivity.class));
            finish();
        }
    }


}