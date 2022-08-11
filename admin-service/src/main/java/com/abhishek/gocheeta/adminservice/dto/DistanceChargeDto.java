package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 16:31
 */
@Getter
@Setter
@ToString
public class DistanceChargeDto implements Transformer {

    private int id;

    @JsonProperty("km_from")
    private int kmFrom;

    @JsonProperty("km_to")
    private int kmTo;

    private double price;

    @JsonProperty("last_update")
    private String lastUpdate;
}
