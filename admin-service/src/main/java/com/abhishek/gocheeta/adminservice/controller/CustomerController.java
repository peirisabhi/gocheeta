package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CustomerDto;
import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.dto.UserDto;
import com.abhishek.gocheeta.adminservice.service.CustomerService;
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
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<CustomerDto> saveCustomer(
            @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(customerDto));
    }


    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(
            @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.updateCustomer(customerDto));
    }


    @DeleteMapping("{customerId}")
    public ResponseEntity<CustomerDto> removeCustomer(
            @PathVariable(value = "customerId") int customerId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.removeCustomer(customerId));
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }


    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomerDto(
            @PathVariable(value = "customerId") int customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }


}
