package com.restaurantservice.restaurantservice.service;

import com.restaurantservice.restaurantservice.exception.*;
import com.restaurantservice.restaurantservice.model.Dishes;
import com.restaurantservice.restaurantservice.model.Restaurant;
import com.restaurantservice.restaurantservice.model.Merchant;

import java.util.List;

public interface IRestaurantService {
    public Merchant registerMerchant(Merchant merchant) throws MerchantAlreadyExistsException;

    Merchant getUser(String userid) throws MerchantNotFoundException;

    public Merchant addRestaurant(Restaurant restaurant, String emailId) throws MerchantNotFoundException, RestaurantAlreadyExistException;

    public List<Restaurant> getAllResaturantByEmailId(String emailId) throws RestaurantNotFoundException, MerchantNotFoundException;

    public List<Restaurant> getAllRestaurants() throws RestaurantNotFoundException;
    public Merchant deleteRestaurant(String emailId, String restId) throws RestaurantNotFoundException, MerchantNotFoundException, RestaurantAlreadyExistException;

    public Restaurant updateRestaurant(String emailId, Restaurant restaurant) throws MerchantNotFoundException, RestaurantNotFoundException;

    public Merchant addDish(String emailId, String restId, Dishes dish)
            throws MerchantNotFoundException, RestaurantNotFoundException, DishAlreadyExistException;
    public Restaurant getoneRestrauntById(String restId) throws RestaurantNotFoundException;
    public Dishes updateDish(String emailId, String restId, String dishId, Dishes updatedDish)
            throws MerchantNotFoundException, RestaurantNotFoundException, DishNotFoundException;

    public Merchant deleteDish(String emailId, String restId, String dishId) throws MerchantNotFoundException, RestaurantNotFoundException, DishNotFoundException;


    public Restaurant getRestaurantByRestId(String restId);

    public Dishes addDishh(String emailId, String restId, Dishes dish)
            throws MerchantNotFoundException, RestaurantNotFoundException, DishAlreadyExistException;
    public Dishes getDishById(String emailId, String restId, String dishId) throws MerchantNotFoundException, RestaurantNotFoundException, DishNotFoundException;

    public Dishes getDishWithoutId(String restId, String dishId) throws RestaurantNotFoundException, DishNotFoundException;


    public List<Dishes> findDishesByCategory(String category);

    Restaurant updateStatus(String merchantId, Restaurant restaurant) throws RestaurantNotFoundException, MerchantNotFoundException;

    List<Merchant> getAllMerchants() throws MerchantNotFoundException;

}
