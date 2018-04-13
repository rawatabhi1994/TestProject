package com.example.abhirawat.testproject.com.novo.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public class RetrofitInstance {
    // /posts
    private static final String baseUrl = "https://jsonplaceholder.typicode.com";
    private Retrofit getRetrofitInstance()
    {

        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
    }

    public ApiService getService()
    {

        return getRetrofitInstance().create(ApiService.class);
    }


}
