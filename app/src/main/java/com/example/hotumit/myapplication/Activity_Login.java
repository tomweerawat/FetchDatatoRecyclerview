package com.example.hotumit.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



/**
 * Created by HOTUM IT on 20/12/2560.
 */

public class Activity_Login extends AppCompatActivity {
    private Button btnsignin;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }


    private void initview(){

        btnsignin = (Button) findViewById(R.id.sigin);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnsignin.setEnabled(false);
                progressDialog = new ProgressDialog(Activity_Login.this,
                        R.style.Theme_AppCompat_Light_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();

                Intent i = new Intent(Activity_Login.this,PullData.class);
                startActivity(i);
            }
        });
    }
    public void login() {


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        initview();

                    }
                }, 3000);
    }
}
