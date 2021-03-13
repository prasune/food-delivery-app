package com.fooddelivery.restaurant.limits.controller;

import com.fooddelivery.restaurant.limits.config.MenuItemLimits;
import com.fooddelivery.restaurant.limits.domain.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LimitsController {

    @Autowired
    private MenuItemLimits menuItemLimits;

    @GetMapping("/limits/property/{propertyName}")
    public ResponseEntity<Limits> getLimits(@PathVariable String propertyName) {
        if (propertyName.equals("menu-items")) {
            return ResponseEntity.ok(new Limits(menuItemLimits.getMinimumValue(),
                    menuItemLimits.getMaximumValue(), menuItemLimits.getDefaultValue()));
        }
        return null;
    }
}
