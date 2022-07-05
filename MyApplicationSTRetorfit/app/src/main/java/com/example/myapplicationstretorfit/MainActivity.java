package com.example.myapplicationstretorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IUserService userService = RetrofitManager.getInstance().getRetrofit().create(IUserService.class);
        Call<ResultModel> call = userService.getUser(1);
        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                Log.i(TAG,"response-->"+response.body());
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Log.i(TAG,"onFailure-->"+t.getMessage());
            }
        });

        /************************文件上传******************/

        File file = new File("/storage/emulated/0/Download/1.jpg");
        MediaType mediaType = MediaType.parse("image/jpg");
        RequestBody fileBody = RequestBody.create(mediaType,file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file",file.getName(),fileBody);
        Call<ResultModel> task = userService.postFile(part);
        task.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call,Response<ResultModel> response) {
                Log.d(TAG,"onResponse -- > " + response.body());
            }

            @Override
            public void onFailure(Call<ResultModel> call,Throwable t) {
                Log.d(TAG,"onFailure -- > " + t.toString());
            }
        });

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            //这里我们的数据格式是json，可以用Gson，也可以用Jackson
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}