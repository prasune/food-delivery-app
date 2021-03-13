package com.fooddelivery.restaurant.domain.converter;

import com.fooddelivery.restaurant.domain.Restaurant;
import com.fooddelivery.restaurant.domain.RestaurantSummary;
import com.fooddelivery.restaurant.repository.entity.RestaurantEntity;

import java.sql.Date;
import java.time.Instant;

public class RestaurantDomainConverter {

    public static Restaurant toRestaurant(RestaurantEntity restaurantEntity) {
        return Restaurant.builder()
                .id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .timeRegistered(Date.from(Instant.ofEpochMilli(restaurantEntity.getTimeRegistered())))
                .timeUpdated(Date.from(Instant.ofEpochMilli(restaurantEntity.getTimeUpdated())))
                .build();
    }

    public static RestaurantSummary toRestaurantSummary(RestaurantEntity restaurantEntity) {
        return RestaurantSummary.builder()
                .id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .timeRegistered(Date.from(Instant.ofEpochMilli(restaurantEntity.getTimeRegistered())))
                .timeUpdated(Date.from(Instant.ofEpochMilli(restaurantEntity.getTimeUpdated())))
                .build();
    }
}
