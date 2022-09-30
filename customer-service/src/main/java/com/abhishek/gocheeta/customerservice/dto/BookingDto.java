package com.abhishek.gocheeta.customerservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 18:05
 */
@Getter
@Setter
@ToString
public class BookingDto implements Transformer {

    private int id;

    @JsonProperty("vehicle_category")
    private int vehicleCategory;

    @JsonProperty("vehicle_category_val")
    private String vehicleCategoryVal;

    @JsonProperty("from_city")
    private int fromCity;

    @JsonProperty("from_city_val")
    private String fromCityVal;

    @JsonProperty("to_city")
    private int toCity;

    @JsonProperty("to_city_val")
    private String toCityVal;

    @JsonProperty("pick_up_street")
    private String pickUpStreet;

    @JsonProperty("drop_off_street")
    private String dropOffStreet;

    @JsonProperty("special_note")
    private String specialNote;

    private String date;

    private String time;

    @JsonProperty("vehicle_no")
    private String vehicleNo;

    private String driver;

    @JsonProperty("end_time")
    private String endTime;

    private String price;

    private String status;

    private int km;

}
