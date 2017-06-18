package com.example.cksya.retrofittry;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cksya.retrofittry.Client.ApiClient;
import com.example.cksya.retrofittry.Model.Users;
import com.example.cksya.retrofittry.Response.Information;
import com.example.cksya.retrofittry.Service.ApiCall;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Users> infoList ;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        infoList = new ArrayList<>();

        try {


            ApiCall apiCall = ApiClient.getRetrofit().create(ApiCall.class);

            Call<ResponseBody> callUsers = apiCall.getInformation();
            callUsers.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                     if(response.isSuccessful()){
                         ResponseBody info = response.body();
                         Log.d("read","" + response.code() +
                                 "  response body "  + response.body() +
                                 " responseError " + response.errorBody() + " responseMessage " +
                                 response.message());

                         Log.d("onResponse", String.valueOf(info.getClass()));

                         Toast.makeText(MainActivity.this, "is successful", Toast.LENGTH_SHORT).show();
                         //Toast.makeText(MainActivity.this, String.valueOf(), Toast.LENGTH_SHORT).show();

                     }else{
                         Toast.makeText(MainActivity.this, "is not sucessfull", Toast.LENGTH_SHORT).show();
                          }

                     }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("error:: " + t.getMessage());
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });
        }catch (Exception e){
            Log.d("error :::",e.getMessage());
        }


    }
}
