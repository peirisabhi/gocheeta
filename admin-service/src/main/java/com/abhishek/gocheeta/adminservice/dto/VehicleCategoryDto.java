package com.abhishek.gocheeta.adminservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleCategoryDto {

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String category;
}
