package com.example.hotumit.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hotumit.myapplication.Model.Item;
import com.example.hotumit.myapplication.R;

import java.util.List;

/**
 * Created by HOTUM IT on 12/10/2560.
 */

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> cartList;
    public CartListAdapter(Context context, List<Item> cartList) {
        this.context = context;
        this.cartList = cartList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Item item = cartList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText(item.getPrice()+""+"Baht");
        Glide.with(context)
                .load(item.getThumbnail())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageView thumbnail;
        public RelativeLayout viewBackground, viewForeground;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);
        }
    }
}
