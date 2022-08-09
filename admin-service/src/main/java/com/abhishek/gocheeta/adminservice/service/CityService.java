package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.commons.model.City;

public interface CityService {

    City saveCity(CityDto cityDto);

}
