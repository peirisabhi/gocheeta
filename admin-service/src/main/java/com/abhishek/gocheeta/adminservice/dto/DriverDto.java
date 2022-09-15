package com.abhishek.gocheeta.adminservice.dto;

import com.abhishek.gocheeta.commons.util.Transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 15:43
 */

@Getter
@Setter
@ToString
@Serialization
@Data
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

    private MultipartFile nicFront;

    private MultipartFile nicBack;

    private MultipartFile drivingLicenceFront;

    private MultipartFile drivingLicenceBack;

    @JsonProperty("registered_at")
    private String registeredAt;

    @JsonProperty("registered_by")
    private int registeredBy;

    @JsonProperty("city_id")
    private int cityId;

    private String city;

}
