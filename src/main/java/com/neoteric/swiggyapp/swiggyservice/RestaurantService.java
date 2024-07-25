package com.neoteric.swiggyapp.swiggyservice;

import com.neoteric.swiggyapp.swiggymodel.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestaurantService {

    public List<Restaurant> restaurantList = new ArrayList<>();

    public Restaurant getRestaurant(String name){

        for (Restaurant restaurant : restaurantList){
            if (Objects.equals(restaurant.restaurantName, name)){
                 return restaurant;

            }
        }
        return null;
    }
}
