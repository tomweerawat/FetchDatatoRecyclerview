package com.example.hotumit.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;

import com.example.hotumit.myapplication.API.MyApi;
import com.example.hotumit.myapplication.Adapter.CartListAdapter;
import com.example.hotumit.myapplication.Model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by HOTUM IT on 11/10/2560.
 */

public class PullData extends AppCompatActivity implements ClickListener {

    Retrofit retrofit;
    MyApi retrofit_service;
    Context context;
    private RecyclerView recyclerView;
    private CartListAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;
   /* private List<Item> cartList;*/
    public static  List<Item> data_list = new ArrayList<>();
    Context c;
    private static final String URL = "https://api.androidhive.info/json/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        callApi();
        getdata();



    }


    private void initview(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.my_cart));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
      /*  mAdapter = new CartListAdapter(this, data_list);
        Log.e("data_list","data_list"+data_list);*/
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);


    }
    private void callApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Log.e("OkHttpClient","connected"+client);
       retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

      retrofit_service = retrofit
                .create(MyApi.class);

    }

    private void getdata(){

        final Call<List<Item>> call = retrofit_service.getitem();
        Log.e("callback","callback"+call);
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                data_list = response.body();
                mAdapter = new CartListAdapter(getApplicationContext(), data_list);
                recyclerView.setAdapter(mAdapter);



            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Pleas try again.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void itemClicked(View view, int position) {
       /* Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("ItemPosition", data.get(position));
        startActivity(intent);*/
       Log.e("click","click");
      /*  Toast.makeText(getApplicationContext(), "position"+data_list.get(position), Toast.LENGTH_LONG).show();*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(getBaseContext(),MapsActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
                }
                }
