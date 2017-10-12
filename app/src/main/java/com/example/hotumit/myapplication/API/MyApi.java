package com.example.hotumit.myapplication.API;

import com.example.hotumit.myapplication.Model.Item;
import com.example.hotumit.myapplication.Model.ItemModel;
import com.example.hotumit.myapplication.Model.PoJo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HOTUM IT on 11/10/2560.
 */

public interface  MyApi {
    @GET("posts")
    Call<ItemModel> getShout();
    @GET("posts")
    Call<List<PoJo>> getstackoverflowResponse();
    @GET("menu.json")
    Call<List<Item>> getitem();
}
