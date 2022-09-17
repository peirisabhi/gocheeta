package com.abhishek.gocheeta.customerservice.service.impl;


import com.abhishek.gocheeta.customerservice.dto.CityDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.exception.GeneralException;
import com.abhishek.gocheeta.customerservice.repository.CityRepository;
import com.abhishek.gocheeta.customerservice.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.CITY_NOT_FOUND;
import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.GENERAL_ERROR;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;


    @Override
    public List<CityDto> getCities() {

        try {
           return cityRepository.findAllByStatus(true)
                    .stream()
                    .map(city -> city.toDto(CityDto.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }



    @Override
    public CityDto getCity(int id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CITY_NOT_FOUND))
                .toDto(CityDto.class);
    }

}
