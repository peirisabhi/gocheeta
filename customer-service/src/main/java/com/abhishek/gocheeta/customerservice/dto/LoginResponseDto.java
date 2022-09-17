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
public class LoginResponseDto {

    private int id;

    private String fname;

    private String lname;

    private String mobile;

    private String email;

    @JsonProperty("jwt_token")
    private String JwtToken;
}
