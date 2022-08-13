package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.CustomerDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.CustomerRepository;
import com.abhishek.gocheeta.adminservice.service.CustomerService;
import com.abhishek.gocheeta.adminservice.util.DateUtil;
import com.abhishek.gocheeta.commons.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 14:20
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        try {
            final Customer customer = customerDto.toEntity(Customer.class);
            customer.setDob(DateUtil.getDate(customerDto.getDob()));
            customer.setRegisteredAt(new Date());
            customer.setStatus(1);

            return customerRepository.save(customer)
                    .toDto(CustomerDto.class);
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException("Invalid Date Format");
        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(CUSTOMER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {

        final Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND));

        try {
            customer.setDob(DateUtil.getDate(customerDto.getDob()));
            customer.setFname(customerDto.getFname());
            customer.setLname(customerDto.getLname());
            customer.setGender(customerDto.getGender());
            customer.setNic(customerDto.getNic());


            return customerRepository.save(customer)
                    .toDto(CustomerDto.class);
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException("Invalid Date Format");
        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(CUSTOMER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CustomerDto removeCustomer(int id) {
        final Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND));

        try {
            customer.setStatus(0);
           return customerRepository.save(customer)
                   .toDto(CustomerDto.class);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CustomerDto getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND))
                .toDto(CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAllByStatus(1)
                .stream().map(customer -> {
                    final CustomerDto customerDto = customer.toDto(CustomerDto.class);
                    customerDto.setDob(DateUtil.getStringDate(customer.getDob()));
                    customerDto.setRegisteredAt(DateUtil.getStringDateWith12Time(customer.getRegisteredAt()));
                    return customerDto;
                }).collect(Collectors.toList());
    }
}
