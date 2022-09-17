package com.abhishek.gocheeta.customerservice.service;


import com.abhishek.gocheeta.customerservice.dto.CustomerDto;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 14:16
 */
public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(int id);

    CustomerDto getCustomerByEmail(String email);

}
