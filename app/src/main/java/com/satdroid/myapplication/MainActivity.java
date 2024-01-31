package com.satdroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    AppCompatButton sendBtn;
    ProgressBar progressBar;

    Handler handler =new Handler(Looper.getMainLooper());

    long network_speed_=2000,free_bytes=400, used_bandwidth=100;
    String node_id="83187343984", battery_status="80%",last_chunk_download_time="5 PM";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sendBtn=findViewById(R.id.send_btn);
         progressBar=findViewById(R.id.pgbar);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendBtn.setEnabled(false);
                Toast.makeText(MainActivity.this, "Send button disabled", Toast.LENGTH_SHORT).show();
                runnable.run();
            }
        });
    }

    void sendData(String node_id,long network_speed_,String battery_status, long free_bytes , long used_bandwidth,String last_chunk_download_time)
    {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://cloud.cypherx.in/register/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi=retrofit.create(RetrofitApi.class);

        postDataModel modal=new postDataModel(node_id,network_speed_,battery_status,free_bytes ,used_bandwidth,last_chunk_download_time);

        Call<postDataModel> call=retrofitApi.createPost(modal);

        call.enqueue(new Callback<postDataModel>() {
            @Override
            public void onResponse(Call<postDataModel> call, Response<postDataModel> response) {

                Toast.makeText(MainActivity.this,"Data send",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<postDataModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Data not send",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sendData(node_id,network_speed_,battery_status,free_bytes,used_bandwidth,last_chunk_download_time);
            handler.postDelayed(runnable,5000);
        }
    };
}

