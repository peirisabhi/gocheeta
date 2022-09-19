package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@AllArgsConstructor
public class CityDto implements Transformer {

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String city;
}
