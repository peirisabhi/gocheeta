package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "distance_charge")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DistanceCharge implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "km_from")
    private int kmFrom;

    @Column(name = "km_to")
    private int kmTo;

    private double price;


    @Column(name = "vehicle_category_id")
    private int vehicleCategoryId;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
