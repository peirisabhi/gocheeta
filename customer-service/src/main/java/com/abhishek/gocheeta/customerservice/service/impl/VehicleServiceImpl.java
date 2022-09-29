package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.CityCharge;
import com.abhishek.gocheeta.commons.model.DistanceCharge;
import com.abhishek.gocheeta.commons.model.Vehicle;
import com.abhishek.gocheeta.customerservice.dto.CityDto;
import com.abhishek.gocheeta.customerservice.dto.VehicleAvailabilityDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.repository.*;
import com.abhishek.gocheeta.customerservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.CITY_NOT_FOUND;
import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.VEHICLE_NOT_FOUND;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 02:24
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityChargeRepository cityChargeRepository;

    @Autowired
    DistanceChargeRepository distanceChargeRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public VehicleAvailabilityDto checkVehicleAvailability(VehicleAvailabilityDto vehicleAvailabilityDto) {

        final List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> vehicle.getVehicleCategoryId() == vehicleAvailabilityDto.getVehicleCategory()
                        && vehicle.getCityId() == vehicleAvailabilityDto.getFromCity()
                )
                .collect(Collectors.toList());

        System.out.println("vehicleList -- " + vehicleList.size());

//        bookingRepository.f

        if (vehicleList.size() > 0) {
//            System.out.println(vehicleList.get(0).toString());

            final CityCharge cityChargeRecord = cityChargeRepository.findAll()
                    .stream()
                    .filter(cityCharge -> cityCharge.getCityFrom() == vehicleAvailabilityDto.getFromCity()
                            || cityCharge.getCityTo() == vehicleAvailabilityDto.getToCity())
                    .findFirst().get();

            System.out.println("cityChargeRecord -- " + cityChargeRecord.getKm());

            final List<DistanceCharge> distanceCharges = distanceChargeRepository
                    .findAllByVehicleCategoryId(vehicleAvailabilityDto.getVehicleCategory())
                    .stream()
                    .sorted(Comparator.comparingInt(DistanceCharge::getKmFrom))
                    .collect(Collectors.toList());

            System.out.println(distanceCharges);

            double price = 0;

            for (DistanceCharge distanceCharge : distanceCharges) {
                final int kmFrom = distanceCharge.getKmFrom();
                final int kmTo = distanceCharge.getKmTo();

                System.out.println("--------------------");
                System.out.println(distanceCharge.toString());

                System.out.println((cityChargeRecord.getKm() > kmFrom) + " - " + (cityChargeRecord.getKm() <= kmTo));

                if(cityChargeRecord.getKm() > kmFrom && cityChargeRecord.getKm() >= kmTo){
                    final int km = kmTo - kmFrom;
                    System.out.println(km + " ---- "+ km * distanceCharge.getPrice());
                    price += km * distanceCharge.getPrice();

                } else if (cityChargeRecord.getKm() > kmFrom && cityChargeRecord.getKm() <= kmTo) {

                    System.out.println("empty km --- " + (cityChargeRecord.getKm() - kmFrom));
                    System.out.println((cityChargeRecord.getKm() - kmFrom) * distanceCharge.getPrice());
                    price += (cityChargeRecord.getKm() - kmFrom) * distanceCharge.getPrice();
                }

            }

            System.out.println("total -- " + price);
            vehicleAvailabilityDto.setAvailability(true);
            vehicleAvailabilityDto.setPrice(String.valueOf(price));
            vehicleAvailabilityDto.setPriceVal(price);
            vehicleAvailabilityDto.setVehicleId(vehicleList.get(0).getId());
            vehicleAvailabilityDto.setTimeDuration(cityChargeRecord.getDuration());

        }else{
            vehicleAvailabilityDto.setAvailability(false);
        }



        return vehicleAvailabilityDto;
    }

    @Override
    public Vehicle getVehicle(int id) {
       return vehicleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_NOT_FOUND));
    }
}
