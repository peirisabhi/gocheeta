package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 11:25
 */
@Getter
@Setter
@ToString
public class CityChargeDto implements Transformer {

    private int id;

    @JsonProperty("km")
    private int km;

    @JsonProperty("city_from")
    private int cityFrom;

    @JsonProperty("city_from_val")
    private String cityFromVal;

    @JsonProperty("city_to")
    private int cityTo;

    @JsonProperty("city_to_val")
    private String cityToVal;
}
