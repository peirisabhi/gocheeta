package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:53
 */
@Getter
@Setter
@ToString
public class UserDto implements Transformer {

    private int id;

    private String fname;

    private String lname;

    private String email;

    private String gender;

    private String nic;

    @JsonProperty("registered_at")
    private Date registeredAt;

    @JsonProperty("user_role_id")
    private int userRoleId;

    private String userRole;

    @JsonProperty("city_id")
    private int cityId;

    private String city;

    public UserDto(String fname, String lname, String email, String gender, String nic, int userRoleId, int cityId) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.gender = gender;
        this.nic = nic;
        this.userRoleId = userRoleId;
        this.cityId = cityId;
    }
}
