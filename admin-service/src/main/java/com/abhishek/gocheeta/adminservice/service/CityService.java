package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.commons.model.City;

import java.util.List;

public interface CityService {

    CityDto saveCity(CityDto cityDto);

    List<CityDto> getCities();

}
