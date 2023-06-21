package com.example.retrofitappwear.service;

import com.example.retrofitappwear.entity.Message;
import com.example.retrofitappwear.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiService {
    @GET("posts/{id}")
    Call<Message> getMessageId(@Path("id") int id);

    @GET("posts")
    Call<List<Message>> getMessageUserId(@Query("userId") int userId);

    @GET("users")
    Call<List<User>> getUserById(@Query("id") int id);
}
