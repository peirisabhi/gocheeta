package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.customerservice.dto.BookingDto;
import com.abhishek.gocheeta.customerservice.repository.BookingRepository;
import com.abhishek.gocheeta.customerservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 18:45
 */
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public BookingDto saveBooking(BookingDto bookingDto) {
        return null;
    }
}
