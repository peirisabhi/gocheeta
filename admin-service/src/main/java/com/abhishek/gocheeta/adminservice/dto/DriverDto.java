package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 15:43
 */

@Getter
@Setter
@ToString
public class DriverDto implements Transformer {

    private int id;

    private String fname;

    private String lname;

    private String email;

    private String gender;

    private String nic;

    private String dob;

    private String contact1;

    private String contact2;

    @JsonProperty("licence_type_id")
    private int licenceTypeId;

    @JsonProperty("licence_type")
    private int licenceType;

    @JsonProperty("nic_front")
    private String nicFront;

    @JsonProperty("nic_back")
    private String nicBack;

    @JsonProperty("driving_licence_front")
    private String drivingLicenceFront;

    @JsonProperty("driving_licence_back")
    private String drivingLicenceBack;

    @JsonProperty("registered_at")
    private String registeredAt;

    @JsonProperty("registered_by")
    private String registeredBy;

}
