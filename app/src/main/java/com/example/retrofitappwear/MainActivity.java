package com.example.retrofitappwear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitappwear.client.RetrofitClient;
import com.example.retrofitappwear.databinding.ActivityMainBinding;
import com.example.retrofitappwear.entity.Message;
import com.example.retrofitappwear.entity.User;
import com.example.retrofitappwear.service.RetrofitApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initValues();
        //getMessage(49);
        //getMessages(2);
        getUser(9);
    }

    private void initView(){
        mTextView = binding.messageTextView;
    }

    private void initValues(){
        apiService = RetrofitClient.getApiService();
    }

    private void getMessage(int id){
        apiService.getMessageId(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                mTextView.setText(message.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }

    private void getMessages(int id){
        apiService.getMessageUserId(id).enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> messages = response.body();
                mTextView.setText("Objetos recuperados: " + messages.size() + "\n\n" + messages.get(messages.size()-1).toString());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }

    private void getUser(int id){
        apiService.getUserById(id).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> user = response.body();
                mTextView.setText(user.toString());

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }
}