package com.fooddelivery.restaurant.limits.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Limits {

    private Integer minimumValue;
    private Integer maximumValue;
    private Integer defaultValue;
}
