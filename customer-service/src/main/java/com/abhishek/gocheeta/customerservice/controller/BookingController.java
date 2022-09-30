package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.BookingDto;
import com.abhishek.gocheeta.customerservice.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-27
 * Time: 00:23
 */
@RestController
@RequestMapping(value = "/booking")
@Slf4j
@CrossOrigin()
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDto> saveBooking(@RequestBody BookingDto bookingDto){
        log.info(bookingDto.toString());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingService.saveBooking(bookingDto));

    }

    @GetMapping("{customerId}")
    public ResponseEntity<List<BookingDto>> getBookingsByRider(@PathVariable(value = "customerId") int customerId){
        return ResponseEntity.ok(bookingService.getBookingsByRider(customerId));
    }

}
