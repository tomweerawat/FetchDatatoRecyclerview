package com.example.hotumit.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotumit.myapplication.API.MyApi;
import com.example.hotumit.myapplication.Model.ItemModel;
import com.example.hotumit.myapplication.Model.PoJo;
import com.example.hotumit.myapplication.Model.Property;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

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

import static android.widget.Toast.LENGTH_LONG;


/**
 * Created by HOTUM IT on 10/10/2560.
 */

public class MainActivity extends Activity  implements Callback<ItemModel> {
   private TextView txtmsg;
    Retrofit retrofit;
    List<PoJo> data_list;
    public static String API="http://jsonplaceholder.typicode.com/";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupRecyclerView();
    }

    private void initview(){
  /*      txtmsg = (TextView) findViewById(R.id.txtmsg);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener(){

            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {

                    Log.e("tab1","tab1"+tabId);

                }
                else if(tabId == R.id.tab_nearby){
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                    Log.e("tab2","tab2");
                }
                else if(tabId == R.id.tab_friends);

                Log.e("tab3","tab3");
            }


        });
*/
    }
    private void setupRecyclerView() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Log.e("OkHttpClient","connected"+client);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Log.e("retrofit2","connected"+API);
        apiCall(retrofit);
        Log.e("apicall","connected"+retrofit);

    }

    private void apiCall(Retrofit retrofit) {
        MyApi myApi = retrofit.create(MyApi.class);
        Call<ItemModel> call = myApi.getShout();
        call.enqueue(this);
        Log.e("apiCall","Success Call");
    }

    @Override
    public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
        ItemModel itemModel = response.body();
        data_list = itemModel.getPojo();
        Log.e("aaaaa","aaaaa"+data_list);

      /*  data = new ArrayList<>(Arrays.asList(itemModel.getPojo()));
        Log.e("aaaaa","aaaaa"+data);
        for(int i=0;i<data.size();i++){
            Log.e("aaaaa","aaaaa"+i);

        }
*/
    }

    @Override
    public void onFailure(Call<ItemModel> call, Throwable t) {
        Log.e("kuy","kuy"+call);
     Toast.makeText(this,"Failed",LENGTH_LONG).show();
    }
}
