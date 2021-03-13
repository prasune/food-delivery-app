package com.fooddelivery.restaurant.service;

import com.fooddelivery.restaurant.domain.CreateRestaurantDetails;
import com.fooddelivery.restaurant.domain.Restaurant;
import com.fooddelivery.restaurant.domain.converter.RestaurantDomainConverter;
import com.fooddelivery.restaurant.domain.RestaurantSummary;
import com.fooddelivery.restaurant.exception.ResourceNotFoundException;
import com.fooddelivery.restaurant.repository.entity.RestaurantEntity;
import com.fooddelivery.restaurant.repository.entity.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements  RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Restaurant createRestaurant(CreateRestaurantDetails createRestaurantDetails) {
        Instant now = Instant.now();
        RestaurantEntity restaurantEntity = RestaurantEntity.builder()
                .name(createRestaurantDetails.getName())
                .timeRegistered(now.toEpochMilli())
                .timeUpdated(now.toEpochMilli())
                .build();
        RestaurantEntity savedEntity = restaurantRepository.save(restaurantEntity);
        return RestaurantDomainConverter.toRestaurant(savedEntity);
    }

    @Override
    public Restaurant getRestaurant(Long restaurantId) {
        Optional<RestaurantEntity> restaurantEntityOptional = restaurantRepository.findById(restaurantId);
        if (!restaurantEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Restaurant");
        }
        return RestaurantDomainConverter.toRestaurant(restaurantEntityOptional.get());
    }

    @Override
    public List<RestaurantSummary> listRestaurants() {
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAll();
        return restaurantEntityList.stream().map(RestaurantDomainConverter::toRestaurantSummary).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteRestaurant(Long restaurantId) {
        Optional<RestaurantEntity> restaurantEntityOptional = restaurantRepository.findById(restaurantId);
        if (!restaurantEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Restaurant");
        }
        restaurantRepository.delete(restaurantEntityOptional.get());
    }
}
