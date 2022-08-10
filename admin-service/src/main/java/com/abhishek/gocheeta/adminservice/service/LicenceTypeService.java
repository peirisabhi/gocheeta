package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.LicenceTypeDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 13:59
 */
public interface LicenceTypeService {

    List<LicenceTypeDto> getLicenceTypes();

    LicenceTypeDto getLicenceType(int id);

}
