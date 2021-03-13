package com.fooddelivery.restaurant.limits.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties("menu-items")
public class MenuItemLimits {

    private Integer minimumValue;
    private Integer maximumValue;
    private Integer defaultValue;
}
