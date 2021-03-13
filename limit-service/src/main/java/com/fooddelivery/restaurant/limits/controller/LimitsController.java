package com.fooddelivery.restaurant.limits.controller;

import com.fooddelivery.restaurant.limits.domain.Limits;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LimitsController {

    @GetMapping("/limits")
    public ResponseEntity<Limits> getLimits() {
        return ResponseEntity.ok(new Limits(1, 100, 10));
    }
}
