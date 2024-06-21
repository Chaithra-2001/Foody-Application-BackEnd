package com.userservice.userservice.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class Restaurant {

    @Id
    private String restId;
    private String name;
    private String imageUrl;
    private  String location;
    private List<Dishes> dishes;
    private boolean status;

    public Restaurant() {
    }

    public Restaurant(String restId, String name, String imageUrl, String location, List<Dishes> dishes,boolean status) {
        this.restId = restId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.location = location;
        this.dishes = dishes;
        this.status=status;
    }

    public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return status == that.status && Objects.equals(name, that.name) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(dishes, that.dishes) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl, dishes, location,status);
    }



    @Override
    public String toString() {
        return "Restaurant{" +
                "restId='" + restId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dishes=" + dishes + '\'' +

                ", status=" + status +
                '}';
    }


}
