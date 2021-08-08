package com.noname.fastmoney.api.network.apiClient;

import com.noname.fastmoney.api.network.apiService.ApiService;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static ApiClient mInstance;
    private static final String BASE_URL = "https://new.smsgorod.ru/apiSms/";
    private final Retrofit mRetrofit;

    private ApiClient(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static ApiClient getInstance() {
        if (mInstance == null) {
            mInstance = new ApiClient();
        }
        return mInstance;
    }

    public ApiService getApiService(){
        return mRetrofit.create(ApiService.class);
    }
}
