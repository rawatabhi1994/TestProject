package com.example.abhirawat.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.abhirawat.testproject.com.novo.interfaces.ListInterface;
import com.example.abhirawat.testproject.com.novo.model.ListModel;
import com.example.abhirawat.testproject.com.novo.presenter.ListActivityPresenter;
import com.example.abhirawat.testproject.com.novo.utils.CheckInternet;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ListInterface {
    private ListView listView;
    private ListActivityPresenter listActivityPresenter;
    boolean checkNet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.listContent);
        listActivityPresenter = new ListActivityPresenter(this);

    }

    @Override
    public void getList(List<ListModel> list) {

    }

    @Override
    public void onFailedResponse(String error) {

    }

    @Override
    public boolean checkConnection() {
        if (CheckInternet.checkConnection(this)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onFailedConnection() {
        Toast.makeText(this,"Connection Is Failed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessfullResponse(List<ListModel> listModels) {

    }

    @Override
    public void onResponseFailed(String errorMessage) {

    }
}
