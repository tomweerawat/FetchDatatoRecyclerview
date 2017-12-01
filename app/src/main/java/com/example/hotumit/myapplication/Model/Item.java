package com.example.hotumit.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ravi on 26/09/17.
 */

public class Item implements Parcelable {
    @Expose
    @SerializedName("id")
    int id;
    @Expose
    @SerializedName("name")
    String name;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("price")
    double price;
    @Expose
    @SerializedName("thumbnail")
    String thumbnail;

    public Item(Parcel parcel) {
        setId(parcel.readInt());
        setDescription(parcel.readString());
        setName(parcel.readString());
        setPrice(parcel.readDouble());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getDescription());
        dest.writeString(getName());
        dest.writeString(getThumbnail());
        dest.writeDouble(getPrice());

    }
}
