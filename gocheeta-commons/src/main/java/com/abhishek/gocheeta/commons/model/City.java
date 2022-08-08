package com.abhishek.gocheeta.commons.model;

import com.abhishek.gocheeta.commons.util.Transformer;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
    private int id;

    private String city;

    private boolean status;


}
