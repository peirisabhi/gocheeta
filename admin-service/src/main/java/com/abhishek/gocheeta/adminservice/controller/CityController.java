package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.commons.model.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/08/2022
 * Time: 2:06 pm
 */

@RestController
@RequestMapping(value = "/services")
public class CityController {

    public String t1(){
        City city = new City();
        return null;
    }

}
