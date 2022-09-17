package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.Customer;
import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.model.UserDetailsImpl;
import com.abhishek.gocheeta.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.CUSTOMER_NOT_FOUND;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-17
 * Time: 00:11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
//    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Customer customer = customerRepository.findByEmail(s)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND));

        return UserDetailsImpl.build(customer);
    }
}
