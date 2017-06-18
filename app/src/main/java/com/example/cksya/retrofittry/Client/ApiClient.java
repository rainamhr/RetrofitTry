package com.example.cksya.retrofittry.Client;

import android.util.Log;

import com.example.cksya.retrofittry.Constant.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cksya on 6/10/17.
 */

public class ApiClient {
    static Retrofit retrofit =null ;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return  retrofit;
    }
}
