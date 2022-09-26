package com.abhishek.gocheeta.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 02:20
 */
@Getter
@Setter
@ToString
public class VehicleAvailabilityDto {

    @JsonProperty("vehicle_category")
    private int vehicleCategory;

    @JsonProperty("from_city")
    private int fromCity;

    @JsonProperty("to_city")
    private int toCity;

    private String price;

    private double priceVal;

    private boolean availability;

    private int vehicleId;

}
