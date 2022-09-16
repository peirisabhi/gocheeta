package com.abhishek.gocheeta.customerservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 14:16
 */
@Getter
@Setter
@ToString
public class CustomerDto implements Transformer {

    private int id;

    private String fname;

    private String lname;

    private String mobile;

    private String email;

    private String gender;

    private String nic;

    private String dob;

    @JsonProperty("registered_at")
    private String registeredAt;

    private String password;

}
