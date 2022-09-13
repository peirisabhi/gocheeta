package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CityChargeDto;
import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 11:25
 */
public interface CityChargeService {

    CityChargeDto saveCityCharge(CityChargeDto cityChargeDto);

    CityChargeDto updateCityCharge(CityChargeDto cityChargeDto);

    CityChargeDto deleteCityCharge(int id);

    List<CityChargeDto> getCityCharges();

    CityChargeDto getCityCharge(int id);

    DataTableResponse<CityChargeDto> getCityChargesForDataTable(DataTableRequest dataTableRequest);
}
