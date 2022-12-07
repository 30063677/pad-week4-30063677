package com.example.restaurantreview;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.contentcapture.ContentCaptureContext;

import androidx.annotation.NonNull;

public class RestaurantReview {

    private String name;
    private float foodQuality;
    private Integer serviceQuality;
    private boolean hasParking;
    private boolean isVegOnly;

    public String getName() {
        return name;
    }

    public RestaurantReview setName(String name) {
        this.name = name;
        return this;
    }

    public float getFoodQuality() {
        return foodQuality;
    }

    public RestaurantReview setFoodQuality(float foodQuality) {
        this.foodQuality = foodQuality;
        return this;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public RestaurantReview setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
        return this;
    }

    public boolean isVegOnly() {
        return isVegOnly;
    }

    public RestaurantReview setVegOnly(boolean vegOnly) {
        isVegOnly = vegOnly;
        return this;
    }

    public Integer getServiceQuality() {
        return serviceQuality;
    }

    public RestaurantReview setServiceQuality(Integer serviceQuality) {
        this.serviceQuality = serviceQuality;
        return this;
    }

    @Override
    public String toString() {
        return "RestaurantReview{" +
                "name='" + name + '\'' +
                ", foodQuality=" + foodQuality +
                ", serviceQuality=" + serviceQuality +
                ", hasParking=" + hasParking +
                ", isVegOnly=" + isVegOnly +
                '}';
    }


}
