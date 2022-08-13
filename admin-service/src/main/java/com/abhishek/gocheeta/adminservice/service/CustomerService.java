package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CustomerDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 14:16
 */
public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto);

    CustomerDto removeCustomer(int id);

    CustomerDto getCustomer(int id);

    List<CustomerDto> getCustomers();



}
