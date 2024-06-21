package com.userservice.userservice.service;

import com.userservice.userservice.exception.*;
import com.userservice.userservice.model.Dishes;
import com.userservice.userservice.model.Order;
import com.userservice.userservice.model.Restaurant;
import com.userservice.userservice.model.User;

import java.util.List;

public interface IUserService {

    public User addUser(User user) throws UserAlreadyExistsException, FavoriteException;

    User addOrder(List<Dishes> dishes, String userId, String date, double price) throws UserNotFoundException, OrderAlreadyExistsException;

    List<Order> getAllOrders(String userId) throws UserNotFoundException, OrderNotFoundException;

    boolean deleteOrder(String orderId, String userId) throws UserNotFoundException, OrderNotFoundException;


    public List<Restaurant> getFavoriteRestaurants(String userId) throws FavoriteException;

    public User addRestaurantToFavorites(String userId, Restaurant restaurant) throws UserNotFoundException, RestaurantAlreadyExistsException;


    public boolean deleteRestaurantFromfavv(String userId, String restaurantId) throws FavoriteException;



    public User addDishToFavorites(String userId, Dishes dish) throws UserNotFoundException, DishAlreadyExistsException;




    public List<Dishes> getFavoriteDishes(String userId) throws FavoriteException;
    public boolean deleteDishFromFavorites(String userId, String dishId) throws FavoriteException;


    public Dishes addDishh(String emailId, String restId, Dishes dish)
            throws UserNotFoundException, RestaurantNotFoundException, DishAlreadyExistsException;


    User getUser(String userid) throws UserNotFoundException;


}
