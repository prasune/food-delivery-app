package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.domain.CreateRestaurantDetails;
import com.fooddelivery.restaurant.domain.Restaurant;
import com.fooddelivery.restaurant.domain.RestaurantSummary;

import java.util.List;


public interface RestaurantService {
    Restaurant createRestaurant(CreateRestaurantDetails createRestaurantDetails);

    Restaurant getRestaurant(Long restaurantId);

    List<RestaurantSummary> listRestaurants();

    void deleteRestaurant(Long restaurantId);
}
