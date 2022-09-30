package com.abhishek.gocheeta.customerservice.service;

import com.abhishek.gocheeta.customerservice.dto.BookingDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 18:37
 */
public interface BookingService {

    BookingDto saveBooking(BookingDto bookingDto);

    List<BookingDto> getBookingsByRider(int id);

}
