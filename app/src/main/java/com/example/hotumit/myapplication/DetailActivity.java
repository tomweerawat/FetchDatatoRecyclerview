package com.example.hotumit.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public int i=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        item = getIntent().getExtras().getParcelable("ItemPosition");
        Toast.makeText(getApplicationContext(), "position = " + item.getThumbnail(), Toast.LENGTH_SHORT).show();
        initview();




    }



    private void loadpic(){
        for(i =0;i<PullData.data_list.size();i++){
           /* Toast.makeText(getApplicationContext(), "position = " + PullData.data_list.get(i), Toast.LENGTH_SHORT).show();*/
            Glide.with(this)
                    .load(PullData.data_list.get(0).getThumbnail())
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
            Log.e("zzzz","zzzz"+PullData.data_list.get(i).getThumbnail());
        }

    }

    private void initview(){
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load(item.getThumbnail())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        txtmsg.setText(item.getName());

    }
    
}
