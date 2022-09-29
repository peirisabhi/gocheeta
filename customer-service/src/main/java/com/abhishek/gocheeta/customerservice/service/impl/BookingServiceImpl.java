package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.*;
import com.abhishek.gocheeta.customerservice.dto.BookingDto;
import com.abhishek.gocheeta.customerservice.dto.VehicleAvailabilityDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.exception.GeneralException;
import com.abhishek.gocheeta.customerservice.repository.BookingRepository;
import com.abhishek.gocheeta.customerservice.repository.BookingStatusHistoryRepository;
import com.abhishek.gocheeta.customerservice.repository.BookingStatusRepository;
import com.abhishek.gocheeta.customerservice.security.JwtTokenUtil;
import com.abhishek.gocheeta.customerservice.service.*;
import com.abhishek.gocheeta.customerservice.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.GENERAL_ERROR;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 18:45
 */
@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    CustomerService customerService;

    @Autowired
    BookingStatusRepository bookingStatusRepository;

    @Autowired
    BookingStatusHistoryRepository bookingStatusHistoryRepository;

    @Autowired
    CityService cityService;

    @Autowired
    VehicleCategoryService vehicleCategoryService;

    @Autowired
    DriverService driverService;

    @Override
    public BookingDto saveBooking(BookingDto bookingDto) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println(username);

        final int customerId = customerService.getCustomerByEmail(username).getId();


        try {


            Booking booking = bookingDto.toEntity(Booking.class);

            VehicleAvailabilityDto vehicleAvailabilityDto = new VehicleAvailabilityDto();
            vehicleAvailabilityDto.setVehicleCategory(bookingDto.getVehicleCategory());
            vehicleAvailabilityDto.setFromCity(bookingDto.getFromCity());
            vehicleAvailabilityDto.setToCity(bookingDto.getToCity());

            vehicleAvailabilityDto = vehicleService.checkVehicleAvailability(vehicleAvailabilityDto);

            if (vehicleAvailabilityDto.isAvailability()) {

                booking.setCustomerId(customerId);
                booking.setPrice(vehicleAvailabilityDto.getPriceVal());
                booking.setVehicleId(vehicleAvailabilityDto.getVehicleId());
                booking.setDate(DateUtil.getDate(bookingDto.getDate()));
                booking.setTime(DateUtil.getTime(bookingDto.getTime()));
                booking.setDropOffCityId(bookingDto.getToCity());
                booking.setDropOffStreetAddress(bookingDto.getDropOffStreet());
                booking.setPickUpCityId(bookingDto.getFromCity());
                booking.setPickUpStreetAddress(bookingDto.getPickUpStreet());
                booking.setEndTime(DateUtil.getTripEndTime(bookingDto.getTime(), vehicleAvailabilityDto.getTimeDuration()));

                booking = bookingRepository.save(booking);

                final BookingStatus bookingStatus = bookingStatusRepository.findById(1).get();

                final BookingStatusHistory bookingStatusHistory = new BookingStatusHistory();
                bookingStatusHistory.setBookingId(booking.getId());
                bookingStatusHistory.setDateTime(new Date());
                bookingStatusHistory.setBookingStatusId(bookingStatus.getId());

                bookingStatusHistoryRepository.save(bookingStatusHistory);

                final Vehicle vehicle = vehicleService.getVehicle(vehicleAvailabilityDto.getVehicleId());
                final Driver driver = driverService.getDriver(vehicle.getDriverId());

                bookingDto.setId(booking.getId());
                bookingDto.setVehicleCategoryVal(vehicleCategoryService.getVehicleCategory(bookingDto.getVehicleCategory()).getCategory());
                bookingDto.setFromCityVal(cityService.getCity(bookingDto.getFromCity()).getCity());
                bookingDto.setToCityVal(cityService.getCity(bookingDto.getToCity()).getCity());
                bookingDto.setVehicleNo(vehicle.getVehicleNumber());
                bookingDto.setDriver(driver.getFname().concat(" ").concat(driver.getLname()));
                bookingDto.setEndTime(DateUtil.getStringTime(booking.getEndTime()));


                return bookingDto;

            } else {
                System.out.println("no available vehicles");
                throw new DataNotFoundException("no available vehicles");
            }


        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
            throw new GeneralException(GENERAL_ERROR);
        }
    }
}
