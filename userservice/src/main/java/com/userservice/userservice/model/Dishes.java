package com.userservice.userservice.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

public class Dishes {
    @MongoId
    private String dishID;
    private String dishname;
    private String imageUrl;
    private String category;
    private float Price;
    private int rating;
    public Dishes() {
    }

    public Dishes(String dishID, String dishname, String imageUrl, String category, float price, int rating) {
        this.dishID = dishID;
        this.dishname = dishname;
        this.imageUrl = imageUrl;
        this.category = category;
        this.Price = price;
        this.rating = rating;
    }

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dish = (Dishes) o;
        return Objects.equals(dishname, dish.dishname)  && Objects.equals(category, dish.category) && Objects.equals(imageUrl, dish.imageUrl) && Objects.equals(Price, dish.Price) && Objects.equals(rating, dish.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishname, Price, category, imageUrl, rating);
    }


    @Override
    public String toString() {
        return "dishes{" +
                "dishID='" + dishID + '\'' +
                ", name='" + dishname + '\'' +
                ", category='" + category + '\'' +
                ", Price=" + Price +
                ", rating=" + rating +
                '}';
    }




}

