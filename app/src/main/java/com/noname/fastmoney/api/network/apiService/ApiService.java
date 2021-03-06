package com.noname.fastmoney.api.network.apiService;

import com.noname.fastmoney.api.requests.auth.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // create?apiKey=vpuxXUEwAiBJdR0GA4CqNPcCZxmx6VlLKjvs9ntzHDosVylwzG3XH9OWxxT7&sms[0][channel]=char&sms[0][phone]=79536506580&sms[0][text]=Ваш код подтверждения: 53486&sms[0][sender]=VIRTA

//    @GET("create?apiKey=vpuxXUEwAiBJdR0GA4CqNPcCZxmx6VlLKjvs9ntzHDosVylwzG3XH9OWxxT7&sms[0][channel]=char&sms[0][phone]={phone}&sms[0][text]={smsCode}&sms[0][sender]=VIRTA")
//    Call<Response> sendSms(@Path("phone") String userPhone, @Path("smsCode") int smsCode);

    @GET("create?apiKey=ccZqmiYNEf7PnPGqk7HvCJVK0TXVTHQpDW5DbBm2OhEPcADksmnJPprmsMQ3&sms[0][channel]=char&sms[0][sender]=VIRTA")
    Call<Response> sendSms(@Query("sms[0][phone]") String userPhone, @Query("sms[0][text]") String fullTextSms);

}
