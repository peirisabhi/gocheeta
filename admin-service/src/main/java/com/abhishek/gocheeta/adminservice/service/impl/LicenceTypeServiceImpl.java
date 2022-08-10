package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.LicenceTypeDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.LicenceTypeRepository;
import com.abhishek.gocheeta.adminservice.service.LicenceTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.LICENCE_TYPE_NOT_FOUND;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 14:07
 */
@Service
@Slf4j
public class LicenceTypeServiceImpl implements LicenceTypeService {

    @Autowired
    LicenceTypeRepository licenceTypeRepository;

    @Override
    public List<LicenceTypeDto> getLicenceTypes() {
        try{
            return licenceTypeRepository.findAll().stream()
                    .map(licenceType -> licenceType.toDto(LicenceTypeDto.class))
                    .collect(Collectors.toList());
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public LicenceTypeDto getLicenceType(int id) {
        return licenceTypeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(LICENCE_TYPE_NOT_FOUND))
                .toDto(LicenceTypeDto.class);
    }
}
