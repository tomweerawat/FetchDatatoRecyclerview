package com.example.hotumit.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.hotumit.myapplication.Model.Item;

/**
 * Created by HOTUM IT on 12/10/2560.
 */

public class DetailActivity extends Activity {
    TextView txtmsg;
    ImageView imageView;
    Item item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        item = getIntent().getExtras().getParcelable("ItemPosition");
        Log.e("zzzz","zzzz"+item.getName());
        initview();


    }
    private void initview(){
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load(item.getThumbnail())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        txtmsg.setText(item.getId()+"\n"+item.getThumbnail()+"\n"+item.getName()+"\n"+item.getPrice());


    }
}
