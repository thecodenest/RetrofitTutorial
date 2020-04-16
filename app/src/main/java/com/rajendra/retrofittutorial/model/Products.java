package com.rajendra.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("quantity")
    private String quantity;

    @SerializedName("unit")
    private String unit;

    public Products(String name, String price, String imageUrl, String quantity, String unit) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
