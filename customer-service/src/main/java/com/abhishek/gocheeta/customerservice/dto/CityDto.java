package com.abhishek.gocheeta.customerservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityDto implements Transformer {

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String city;
}
