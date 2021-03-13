package com.fooddelivery.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRestaurantDetails {

    @Size(min=2, message="Name should have at least 2 characters")
    private String name;
}
