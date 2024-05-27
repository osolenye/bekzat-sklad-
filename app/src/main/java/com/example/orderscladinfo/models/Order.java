package com.example.orderscladinfo.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Order implements Parcelable, Serializable {
    @SerializedName("username")
    @Expose
    String nameUser;
    @SerializedName("title")
    @Expose
    String nameProduct;
    @SerializedName("price")
    @Expose
    String priceProduct;
    @SerializedName("address")
    @Expose
    String addressUser;
    @SerializedName("counter_product")
    @Expose
    int counterProduct;
    @SerializedName("image")
    @Expose
    String modelImage;


    public int getCounterProduct() {
        return counterProduct;
    }

    public void setCounterProduct(int counterProduct) {
        this.counterProduct = counterProduct;
    }

    public String getModelImage() {
        return modelImage;
    }

    public void setModelImage(String modelImage) {
        this.modelImage = modelImage;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    protected Order(Parcel in) {
        nameUser = in.readString();
        nameProduct = in.readString();
        priceProduct = in.readString();
        addressUser = in.readString();
        modelImage=in.readString();
        counterProduct=in.readInt();
    }

    public Order(String nameUser, String addressUser,String modelImage,String nameProduct, String priceProduct,  int counterProduct ) {
        this.nameUser = nameUser;
        this.addressUser = addressUser;
        this.modelImage = modelImage;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.counterProduct = counterProduct;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(modelImage);
        dest.writeInt(counterProduct);
        dest.writeString(nameUser);
        dest.writeString(nameProduct);
        dest.writeString(priceProduct);
        dest.writeString(addressUser);
    }
}
