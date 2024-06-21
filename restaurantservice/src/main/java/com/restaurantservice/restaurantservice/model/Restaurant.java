package com.restaurantservice.restaurantservice.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;


public class Restaurant {
    @Id
    private String restId;
    private String name;
    private  String location;
    private String imageUrl;
    private List<Dishes> dishList;

    private Boolean status;
    public Restaurant() {
    }

    public Restaurant(String restId, String name, String location, String imageUrl, List<Dishes> dishList,Boolean status) {
        this.restId = restId;
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.dishList = dishList;
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) && Objects.equals(imageUrl, that.imageUrl)  && Objects.equals(location, that.location)  && Objects.equals(status, that.status) && Objects.equals(dishList, that.dishList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl, dishList, location, status);
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public List<Dishes> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dishes> dishList) {
        this.dishList = dishList;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restId='" + restId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dishes=" + dishList +'\'' +
                ", status=" + status +
                '}';

    }


}
