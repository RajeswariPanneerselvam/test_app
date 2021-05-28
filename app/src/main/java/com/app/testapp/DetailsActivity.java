package com.app.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.testapp.adapter.RecyclerItemAdapter;
import com.app.testapp.apiservice.ApiClient;
import com.app.testapp.apiservice.ApiInterface;
import com.app.testapp.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    ImageView person_image;
    TextView text_name,text_description;
    List<DataModel>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        person_image=findViewById(R.id.person_image);
        text_name=findViewById(R.id.person_name);
        text_description=findViewById(R.id.person_desc);
        data= AppController.getInstance().details;
        text_name.setText(data.get(0).getName());
        text_description.setText(data.get(0).getDescription());
        Picasso.with(DetailsActivity.this).load(data.get(0).owner.getAvatar_url()).into(person_image);



    }


}