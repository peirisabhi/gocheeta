package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "driver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Driver implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fname;

    private String lname;

    @Column(unique = true, length = 512)
    private String email;

    @Column(length = 16)
    private String gender;

    @Column(unique = true, length = 16)
    private String nic;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 16)
    private String contact1;

    @Column(length = 16)
    private String contact2;

    @Column(name = "licence_type_id")
    private int licenceTypeId;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "nic_front", length = 512)
    private String nicFront;

    @Column(name = "nic_back", length = 512)
    private String nicBack;

    @Column(name = "driving_licence_front", length = 512)
    private String drivingLicenceFront;

    @Column(name = "driving_licence_back", length = 512)
    private String drivingLicenceBack;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(name = "registered_by")
    private int registeredBy;

    @Column(length = 1)
    private int status;

    private boolean availability;
}
