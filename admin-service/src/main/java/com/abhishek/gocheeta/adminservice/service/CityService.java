package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;

import java.util.List;

public interface CityService {

    CityDto saveCity(CityDto cityDto);

    List<CityDto> getCities();

    CityDto updateCity(CityDto cityDto);

    CityDto removeCity(int id);

    CityDto getCity(int id);

    DataTableResponse<CityDto> getCitiesForDataTable(DataTableRequest dataTableRequest);
}
