package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Booking implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "time", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "end_time", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date endTime;

    private double price;

    @Column(name = "pick_up_city_id")
    private int pickUpCityId;

    @Column(name = "drop_off_city_id")
    private int dropOffCityId;

    @Column(name = "pick_up_street_address")
    private String pickUpStreetAddress;

    @Column(name = "drop_off_street_address")
    private String dropOffStreetAddress;
}
