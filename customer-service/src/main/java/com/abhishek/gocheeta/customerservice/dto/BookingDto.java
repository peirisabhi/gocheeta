package com.abhishek.gocheeta.customerservice.dto;

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
public class BookingDto {

    private int id;

    @JsonProperty("vehicle_category")
    private int vehicleCategory;

    @JsonProperty("from_city")
    private int fromCity;

    @JsonProperty("to_city")
    private int toCity;

    @JsonProperty("pick_up_street")
    private String pickUpStreet;

    @JsonProperty("drop_off_street")
    private String dropOffStreet;

    @JsonProperty("special_note")
    private String specialNote;
}
