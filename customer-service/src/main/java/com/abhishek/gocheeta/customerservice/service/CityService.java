package com.abhishek.gocheeta.customerservice.service;

import com.abhishek.gocheeta.customerservice.dto.CityDto;

import java.util.List;

public interface CityService {

    List<CityDto> getCities();

    CityDto getCity(int id);

}
