package com.example.hotumit.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HOTUM IT on 11/10/2560.
 */

public class PoJo {
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("body")
    private String body;

    @Expose
    @SerializedName("Userid")
    private int Userid;

    @Expose
    @SerializedName("id")
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
