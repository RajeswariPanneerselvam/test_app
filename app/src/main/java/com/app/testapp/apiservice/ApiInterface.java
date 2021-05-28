package com.app.testapp.apiservice;

import com.app.testapp.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("/repositories")
    Call<List<DataModel>> getDataList();

}