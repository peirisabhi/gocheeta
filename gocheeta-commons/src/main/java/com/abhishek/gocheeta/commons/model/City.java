package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;


import javax.persistence.*;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/08/2022
 * Time: 12:58 pm
 */
@Entity
@Table(name = "city")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class City implements Transformer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private boolean status;


}
