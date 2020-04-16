package com.rajendra.retrofittutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rajendra.retrofittutorial.adapter.ProductRecyclerAdapter;
import com.rajendra.retrofittutorial.model.Products;
import com.rajendra.retrofittutorial.retrofit.ApiInterface;
import com.rajendra.retrofittutorial.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ProductRecyclerAdapter productRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<Products>> call = apiInterface.getAllProduct();

        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {

                List<Products> products = response.body();

                setRecyclerData(products); //done Lets run

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });

    }

    private void setRecyclerData(List<Products> productsList){

        recyclerView = findViewById(R.id.recyclerview);
        productRecyclerAdapter = new ProductRecyclerAdapter(productsList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productRecyclerAdapter);
        productRecyclerAdapter.notifyDataSetChanged();

    }

    // Tutorial completed
    // In next part i will use retrofit with RxJava and fetch data from sever on a saperate thread.
    

}
