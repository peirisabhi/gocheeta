package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "city_charge")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CityCharge implements Transformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int km;

    @Column(name = "city_from")
    private int cityFrom;

    @Column(name = "city_to")
    private int cityTo;

    private double price;

    private int duration;
}
