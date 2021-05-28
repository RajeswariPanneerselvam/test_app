package com.app.testapp;

import android.app.Application;

import com.app.testapp.model.DataModel;

import java.util.List;

public class AppController extends Application {
    static AppController mInstance;

    public static AppController getInstance() {
        if (mInstance == null) {
            mInstance = new AppController();
        }
        return mInstance;
    }
    public List<DataModel> details;

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public DataModel data;


    public List<DataModel> getDetails() {
        return details;
    }

    public void setDetails(List<DataModel> details) {
        this.details = details;
    }


}

