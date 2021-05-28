package com.app.testapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.app.testapp.adapter.RecyclerItemAdapter;
import com.app.testapp.apiservice.ApiClient;
import com.app.testapp.apiservice.ApiInterface;
import com.app.testapp.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClick {


    RecyclerView recyclerView;
    RecyclerItemAdapter adapter;
    ProgressDialog progressDialog;
    List<DataModel> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView=findViewById(R.id.recyclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
         recyclerView.setHasFixedSize(true);

       DataViewModel model = ViewModelProviders.of(this).get(DataViewModel.class);

        model.getHeroes().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(@Nullable List<DataModel> heroList) {
                adapter = new RecyclerItemAdapter(heroList,MainActivity.this,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        });

        // getData();

    }



    /* Get Data Service*/
    private void getData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data..");
        progressDialog.setCancelable(false);
        progressDialog.show();


        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<DataModel>> call = service.getDataList();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {


                data  =response.body();
                adapter=new RecyclerItemAdapter(data,MainActivity.this,MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                AppController.getInstance().setDetails(response.body());
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
    }

    @Override
    public void onClicked(List<DataModel> data) {

        AppController.getInstance().details=data;
      startActivity(new Intent(getApplicationContext(),DetailsActivity.class));
    }
}