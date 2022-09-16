package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import com.abhishek.gocheeta.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 15:08
 */
@RestController
@RequestMapping(value = "/customer")
@Slf4j
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<CustomerDto> saveCustomer(
            @RequestBody CustomerDto customerDto) {
        log.info(customerDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(customerDto));
    }


    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(
            @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.updateCustomer(customerDto));
    }


    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomerDto(
            @PathVariable(value = "customerId") int customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }


}
