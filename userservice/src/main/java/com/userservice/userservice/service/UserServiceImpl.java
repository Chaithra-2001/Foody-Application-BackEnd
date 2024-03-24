package com.userservice.userservice.service;

import com.userservice.userservice.exception.*;
import com.userservice.userservice.model.Dishes;
import com.userservice.userservice.model.Restaurant;
import com.userservice.userservice.model.User;
import com.userservice.userservice.proxy.UserProxy;
import com.userservice.userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository iUserRepository;
    private final UserProxy userProxy;


    @Autowired
    public UserServiceImpl(IUserRepository iUserRepository, UserProxy userProxy) {
        this.iUserRepository = iUserRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        {
            if (iUserRepository.findById(user.getEmailId()).isPresent()) {
                throw new UserAlreadyExistsException("User already exist");
            } else {

                User inserted = iUserRepository.save(user);
                userProxy.saveUser(inserted);
                return inserted;
            }
        }
    }





@Override
public User addRestaurantToFavorites(String userId, Restaurant restaurant) throws UserNotFoundException, RestaurantAlreadyExistsException {
    Optional<User> optionalUser = iUserRepository.findById(userId);

    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        List<Restaurant> userFav = user.getFavoriteRestaurant();

        if (userFav == null) {
            // If favoriteRestaurant is null, initialize a new list
            userFav = new ArrayList<>();
        }

        // Check if restaurant with the same ID already exists in user's favorites
        boolean exists = userFav.contains(restaurant);

        if (exists) {
            throw new RestaurantAlreadyExistsException("Restaurant already present");
        } else {
            userFav.add(restaurant);
            user.setFavoriteRestaurant(userFav);
            iUserRepository.save(user);
            return user;
        }
    } else {
        throw new UserNotFoundException("User does not exist!");
    }
}

    @Override
    public List<Restaurant> getFavoriteRestaurants(String userId) throws FavoriteException {
        Optional<User> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Restaurant> favoriteRestaurants = user.getFavoriteRestaurant();
            return favoriteRestaurants != null ? favoriteRestaurants : Collections.emptyList();
        } else {
            throw new FavoriteException("User not found");
        }
    }


    @Override
    public boolean deleteRestaurantFromfavv(String userId, String restaurantId) throws FavoriteException {
        Optional<User> userOptional = iUserRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Restaurant> restaurantList = user.getFavoriteRestaurant();
            Optional<Restaurant> restaurantOptional = restaurantList.stream()
                    .filter(filtered -> filtered.getRestId().equalsIgnoreCase(restaurantId))
                    .findAny();
            if (restaurantOptional.isPresent()) {
                restaurantList.remove(restaurantOptional.get());
                user.setFavoriteRestaurant(restaurantList);
                iUserRepository.save(user);
                return true;
            } else {
                throw new FavoriteException("Restaurant not found");
            }
        } else {
            throw new FavoriteException("User not found");
        }
    }

    @Override
    public User addDishToFavorites(String userId, Dishes dish) throws UserNotFoundException, DishAlreadyExistsException {
        Optional<User> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Dishes> dishList = user.getFavoriteDish();

            if (dishList == null) {
                dishList = new ArrayList<>();
            }

            // Check if dish with the same ID already exists in user's favorite dishes
            boolean exists = dishList.contains(dish);

            if (exists) {
                throw new DishAlreadyExistsException("Dish already present");
            } else {
                dishList.add(dish);
                user.setFavoriteDish(dishList);
                iUserRepository.save(user);
                return user;
            }
        } else {
            throw new UserNotFoundException("User does not exist");
        }
    }

//    @Override
//    public User addDishToFavorites(String userId, Dishes dish) throws UserNotFoundException, DishAlreadyExistsException {
//        Optional<User> optionalUser = iUserRepository.findById(userId);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            List<Dishes> dishList = user.getFavoriteDish();
//
//            if (dishList == null) {
//                dishList = new ArrayList<>();
//            }
//
//            // Check if dish with the same ID already exists in user's favorite dishes
//            boolean exists = dishList.contains(dish);
//
//            if (exists) {
//                throw new DishAlreadyExistsException("Dish already present");
//            } else {
//                dishList.add(dish);
//                user.setFavoriteDish(dishList);
//                iUserRepository.save(user);
//                return user;
//            }
//        } else {
//            throw new UserNotFoundException("User does not exist");
//        }
//    }



    @Override
    public List<Dishes> getFavoriteDishes(String userId) throws FavoriteException {
        Optional<User> optionalUser = iUserRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Dishes> favoriteDishes = user.getFavoriteDish();
            return favoriteDishes != null ? favoriteDishes : Collections.emptyList();
        } else {
            throw new FavoriteException("User not found");
        }
    }
    @Override
    public boolean deleteDishFromFavorites(String userId, String dishId) throws FavoriteException {
        Optional<User> userOptional = iUserRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Dishes> dishList = user.getFavoriteDish();
            Optional<Dishes> dishOptional = dishList.stream()
                    .filter(filtered -> filtered.getDishID().equalsIgnoreCase(dishId))
                    .findAny();
            if (dishOptional.isPresent()) {
                dishList.remove(dishOptional.get());
                user.setFavoriteDish(dishList);
                iUserRepository.save(user);
                return true;
            } else {
                throw new FavoriteException("Dish not found");
            }
        } else {
            throw new FavoriteException("User not found");
        }

    }



    @Override
    public Dishes addDishh(String emailId, String restId, Dishes dish)
            throws UserNotFoundException, RestaurantNotFoundException, DishAlreadyExistsException {
        Optional<User> merchantOptional = iUserRepository.findByEmailId(emailId);
        if (merchantOptional.isPresent()) {
            User merchant = merchantOptional.get();
            List<Restaurant> restaurantList = merchant.getFavoriteRestaurant();
            boolean restaurantFound = false;

            for (Restaurant existingRestaurant : restaurantList) {
                if (existingRestaurant.getRestId().equals(restId)) {
                    restaurantFound = true;
                    List<Dishes> dishesList = existingRestaurant.getDishes();
                    if (dishesList == null) {
                        existingRestaurant.setDishes(new ArrayList<>(List.of(dish)));
                    } else {
                        boolean dishFound = dishesList.stream().anyMatch(d -> d.getDishID().equals(dish.getDishID()));
                        if (dishFound) {
                            throw new DishAlreadyExistsException("Dish already exists in the restaurant");
                        } else {
                            dishesList.add(dish);
                            existingRestaurant.setDishes(dishesList);
                        }
                    }
                    break;
                }
            }

            if (restaurantFound) {
                iUserRepository.save(merchant);
                return dish; // Return the added dish
            } else {
                throw new RestaurantNotFoundException("Restaurant not found in the merchants list");
            }
        } else {
            throw new UserNotFoundException("user not found");
        }
    }

    @Override
    public User getUser(String userid) throws UserNotFoundException {
      Optional<User> userOptional=iUserRepository.findById(userid);
      if(userOptional.isPresent()){
          User user= iUserRepository.findById(userid).get();
          return user;
      }
      else{
          throw new UserNotFoundException("user not found");
      }
    }


}




















