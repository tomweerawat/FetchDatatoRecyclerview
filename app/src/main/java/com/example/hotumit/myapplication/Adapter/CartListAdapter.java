package com.example.hotumit.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hotumit.myapplication.ClickListener;
import com.example.hotumit.myapplication.DetailActivity;
import com.example.hotumit.myapplication.MapsActivity;
import com.example.hotumit.myapplication.Model.Item;
import com.example.hotumit.myapplication.PullData;
import com.example.hotumit.myapplication.R;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by HOTUM IT on 12/10/2560.
 */

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> cartList;
    private static ClickListener clicklistener = null;
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
    public void setClickListener(ClickListener listener) {
        this.clicklistener = listener;
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
        Log.e("pic","pic"+item.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }else {
                /*Toast.makeText(v.getContext(), "position = " + PullData.data_list.get(getPosition()), Toast.LENGTH_SHORT).show();
                Log.e("ggwp","ggwp"+PullData.data_list.get(getPosition()));*/
          /*      Toast.makeText(context,"ggwp",Toast.LENGTH_LONG).show();*/
                Intent i = new Intent(context,DetailActivity.class);
                i.putExtra("ItemPosition", PullData.data_list.get(getAdapterPosition()));
              /*  Toast.makeText(v.getContext(), "position = " + PullData.data_list.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();*/
                context.startActivity(i);
            }


        }
    }
}
