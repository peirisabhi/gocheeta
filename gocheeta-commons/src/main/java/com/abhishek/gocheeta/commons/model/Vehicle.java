package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vehicle implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vehicle_category_id")
    private int vehicleCategoryId;

    @Column(name = "vehicle_make")
    private String vehicleMake;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "mac_passengers")
    private int maxPassengers;

    @Column(name = "registered_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(name = "registered_by")
    private int registeredBy;

    @Column(length = 1)
    private int status;

    @Column(name = "driver_id")
    private int driverId;
}
