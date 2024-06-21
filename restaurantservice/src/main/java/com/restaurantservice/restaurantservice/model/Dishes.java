package com.restaurantservice.restaurantservice.model;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

public class Dishes {
    @MongoId
    private String dishID;
    private String dishname;
    private String category;
    private  String imageUrl;
    private int price;
    private int rating;

    public Dishes() {
    }

    public Dishes(String dishID, String dishname, String category, String imageUrl, int price, int rating) {
        this.dishID = dishID;
        this.dishname = dishname;
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dish = (Dishes) o;
        return price == dish.price && Objects.equals(dishname, dish.dishname)  && Objects.equals(category, dish.category) && Objects.equals(imageUrl, dish.imageUrl) && Objects.equals(price, dish.price) && Objects.equals(rating, dish.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishname, price, category, imageUrl, rating);
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "dishes{" +
                "dishID='" + dishID + '\'' +
                ", name='" + dishname + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }


}