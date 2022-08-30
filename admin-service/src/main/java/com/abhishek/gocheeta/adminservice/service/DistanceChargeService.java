package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 16:28
 */
public interface DistanceChargeService {

    DistanceChargeDto saveDistanceCharge(DistanceChargeDto distanceChargeDto);

    DistanceChargeDto updateDistanceCharge(DistanceChargeDto distanceChargeDto);

    DistanceChargeDto deleteDistanceCharge(int id);

    List<DistanceChargeDto> getDistanceCharges();

    DistanceChargeDto getDistanceCharge(int id);

    DataTableResponse<DistanceChargeDto> getDistanceChargesForDataTable(DataTableRequest dataTableRequest);

}
