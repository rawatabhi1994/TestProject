package com.example.abhirawat.testproject.com.novo.presenter;

import com.example.abhirawat.testproject.com.novo.interfaces.ListInterface;
import com.example.abhirawat.testproject.com.novo.interfaces.ListPresenterInterface;
import com.example.abhirawat.testproject.com.novo.model.ListModel;
import com.example.abhirawat.testproject.com.novo.retrofit.ApiService;
import com.example.abhirawat.testproject.com.novo.retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public class ListActivityPresenter implements ListPresenterInterface {
    private ListInterface listInterface;

    public ListActivityPresenter(ListInterface listInterface) {

        this.listInterface = listInterface;
    }

    @Override
    public void fetchList() {
        if(listInterface.checkConnection())
        {

        ApiService service = new RetrofitInstance().getService();
        Call<List<ListModel>> call = service.getPosts();
        call.enqueue(new Callback<List<ListModel>>() {
            @Override
            public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
              List<ListModel> listModelList = response.body();
              listInterface.onSuccessfullResponse(listModelList);
            }

            @Override
            public void onFailure(Call<List<ListModel>> call, Throwable t) {
             listInterface.onFailedResponse("Response Failure");
            }
        });

    }

    else
        {
        listInterface.onFailedConnection();

        }
    }

}
