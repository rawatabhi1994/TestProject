package com.example.abhirawat.testproject.com.novo.retrofit;

import com.example.abhirawat.testproject.com.novo.model.ListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public interface ApiService {
    @GET("/posts/{id}")
    Call<List<ListModel>> getPosts(int id);
}
