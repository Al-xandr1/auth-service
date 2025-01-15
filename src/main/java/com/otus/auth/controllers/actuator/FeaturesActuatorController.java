package com.otus.auth.controllers.actuator;

import com.otus.auth.config.FeatureFlags;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

/*
    Кастомный кастомный endpoint для включения или отключения фич
    Используется в качестве примера
 */
@Component
@Endpoint(id = "features")
@AllArgsConstructor
public class FeaturesActuatorController {

    private final FeatureFlags features;

    @ReadOperation
    public FeatureFlags features() {
        return features;
    }

    @ReadOperation
    public Boolean feature(@Selector String name) {
        return features.getFlags().get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, Boolean enabled) {
        features.getFlags().put(name, enabled);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.getFlags().remove(name);
    }
}