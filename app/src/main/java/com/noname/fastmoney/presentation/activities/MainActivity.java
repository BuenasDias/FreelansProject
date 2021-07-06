package com.noname.fastmoney.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.noname.fastmoney.App;
import com.noname.fastmoney.api.network.apiClient.ApiClient;
import com.noname.fastmoney.api.requests.auth.Response;
import com.noname.fastmoney.data.dao.UserDao;
import com.noname.fastmoney.data.database.AppDatabase;
import com.noname.fastmoney.data.entities.User;
import com.noname.fastmoney.databinding.ActivityMainBinding;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private UserDao userDao;
    private Response responseBody;
    private int passCode;
    private String fullTextSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        AppDatabase db = App.getInstance().getDatabase();
        userDao = db.mUserDao();
        setTitle("Добро пожаловать!");
        checkAuth();
        passCode = generateCode();
        fullTextSms = "Ваш код подтверждения: " + passCode;

        mBinding.btnAuthorization.setOnClickListener(view -> {

            if(mBinding.userPhone.getRawText().length() == 9){

                String phone = "380" + mBinding.userPhone.getRawText();
                Log.d("TAG", "380" + mBinding.userPhone.getRawText());

                ApiClient.getInstance()
                        .getApiService()
                        .sendSms(phone, fullTextSms)
                        .enqueue(new Callback<Response>() {
                            @Override
                            public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                                responseBody = response.body();
                                if(Objects.requireNonNull(responseBody).getStatus().equalsIgnoreCase("success")){
                                    showEditPass();
                                    hideEditPhone();
                                } else {
                                    Toast.makeText(MainActivity.this, "Ошибка ответа от сервера", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {
                                t.printStackTrace();
                                Toast.makeText(MainActivity.this, "Ошибка ответа от сервера", Toast.LENGTH_LONG).show();
                            }
                        });
            } else {
                mBinding.textErrorSms.setVisibility(View.VISIBLE);
                mBinding.textErrorSms.setText("Неверный формат телефона");
            }
        });

        mBinding.btnCheckSms.setOnClickListener(v -> {
            if(Integer.parseInt(mBinding.editSms.getText().toString().trim()) == passCode){

                startActivity(new Intent(this, CatalogActivity.class));

                User user = new User();
                user.id = 1;
                user.auth = 1;

                userDao.updateUser(user);

            } else {
                mBinding.textErrorSms.setVisibility(View.VISIBLE);
            }
        });

        mBinding.btnBack.setOnClickListener(v -> {
            showEditPhone();
            hideEditPass();
        });
    }

    private void hideEditPass() {
        mBinding.btnCheckSms.setVisibility(View.GONE);
        mBinding.editSms.setVisibility(View.GONE);
        mBinding.btnBack.setVisibility(View.GONE);
    }

    private void showEditPhone() {
        mBinding.userName.setVisibility(View.VISIBLE);
        mBinding.userPhone.setVisibility(View.VISIBLE);
        mBinding.btnAuthorization.setVisibility(View.VISIBLE);
    }

    private void hideEditPhone() {
        mBinding.userName.setVisibility(View.GONE);
        mBinding.userPhone.setVisibility(View.GONE);
        mBinding.btnAuthorization.setVisibility(View.GONE);
    }

    private void showEditPass() {
        mBinding.btnCheckSms.setVisibility(View.VISIBLE);
        mBinding.editSms.setVisibility(View.VISIBLE);
        mBinding.btnBack.setVisibility(View.VISIBLE);
    }

    // Generate #### number
    private int generateCode() {
        return (int) (Math.random() * 10000) + 1000;
    }

    private void checkAuth() {
        User user = userDao.getUserById(1);

        if (user.auth != 0) {
            startActivity(new Intent(this, CatalogActivity.class));
            finish();
        }
    }
}