package com.app.testapp;

import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.testapp.adapter.RecyclerItemAdapter;
import com.app.testapp.apiservice.ApiClient;
import com.app.testapp.apiservice.ApiInterface;
import com.app.testapp.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
    ProgressDialog progressDialog;

    private MutableLiveData<List<DataModel>> data;

    //we will call this method to get the data
    public LiveData<List<DataModel>> getHeroes() {
        //if the list is null 
        if (data == null) {
            data = new MutableLiveData<List<DataModel>>();
            //we will load it asynchronously from server in this method
            getData();
        }

        //finally we will return the list
        return data;
    }

    private void getData() {



        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<DataModel>> call = service.getDataList();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {


                data .setValue(response.body());

                AppController.getInstance().setDetails(response.body());



            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });
    }

}
