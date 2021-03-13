package com.fooddelivery.restaurant.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName) {
        super(resourceName + " resource is Not Authorized or Not Found");
    }
}
