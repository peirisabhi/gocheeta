package com.abhishek.gocheeta.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-17
 * Time: 09:32
 */
@Getter
@Setter
@ToString
public class LoginResponseDto<T> {

    private T data;

    @JsonProperty("jwt_token")
    private String JwtToken;
}
