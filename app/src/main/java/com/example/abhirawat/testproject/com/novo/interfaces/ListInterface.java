package com.example.abhirawat.testproject.com.novo.interfaces;

import com.example.abhirawat.testproject.com.novo.model.ListModel;

import java.util.List;

/**
 * Created by Abhi Rawat on 12-04-2018.
 */

public interface ListInterface {
    void getList(List<ListModel> list);
    void onFailedResponse(String error);
    boolean checkConnection();
    void  onFailedConnection();
    void onSuccessfullResponse(List<ListModel> listModels);
    void onResponseFailed(String errorMessage);
}
