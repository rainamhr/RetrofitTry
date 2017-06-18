package com.example.cksya.retrofittry.Service;

import com.example.cksya.retrofittry.Response.Information;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by cksya on 6/10/17.
 */

public interface ApiCall {
    @GET ("contacts/")
    Call<ResponseBody> getInformation();
}
