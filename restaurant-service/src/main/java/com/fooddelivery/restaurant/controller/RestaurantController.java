package com.fooddelivery.restaurant.controller;

import javax.validation.Valid;

import com.fooddelivery.restaurant.domain.CreateRestaurantDetails;
import com.fooddelivery.restaurant.domain.Restaurant;
import com.fooddelivery.restaurant.domain.RestaurantSummary;
import com.fooddelivery.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody CreateRestaurantDetails createRestaurantDetails) {
        Restaurant savedRestaurant = restaurantService.createRestaurant(createRestaurantDetails);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{restaurantId}")
                .buildAndExpand(savedRestaurant.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<EntityModel<Restaurant>> getRestaurant(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

        // Create a link to list restaurants API and add it to the entity model
        EntityModel<Restaurant> resource = EntityModel.of(restaurant);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).listRestaurants());
        resource.add(linkTo.withRel("all-restaurants"));
        return ResponseEntity.ok(resource);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantSummary>> listRestaurants() {
        List<RestaurantSummary> restaurantList = restaurantService.listRestaurants();
        return ResponseEntity.ok(restaurantList);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.noContent().build();
    }
}
