package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 21:13
 */
@Getter
@Setter
@ToString
public class VehicleDto implements Transformer {

    private int id;

    @JsonProperty("vehicle_category_id")
    private int vehicleCategoryId;

    @JsonProperty("vehicle_category")
    private String vehicleCategory;

    @JsonProperty("vehicle_make")
    private String vehicleMake;

    @JsonProperty("vehicle_model")
    private String vehicleModel;

    @JsonProperty("vehicle_number")
    private String vehicleNumber;

    @JsonProperty("mac_passengers")
    private int maxPassengers;

    @JsonProperty("registered_at")
    private String registeredAt;

    @JsonProperty("registered_by")
    private int registeredBy;

    @JsonProperty("driver_id")
    private int driverId;

    private String driver;

    @JsonProperty("city_id")
    private int cityId;

    private String city;


}
