package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.Customer;
import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.model.UserDetailsImpl;
import com.abhishek.gocheeta.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.CUSTOMER_NOT_FOUND;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-17
 * Time: 00:11
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

//    @Override
////    @Transactional
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        log.info("loadUserByUsername -- " + s);
////        final Customer customer = customerRepository.findByEmail(s)
////                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + s));
////        System.out.println(customer.toString());
////        return UserDetailsImpl.build(customer);
//
//        final UserDetailsImpl userDetails = new UserDetailsImpl(1, "abc", "asa", "asa", "asa");
//
//        return userDetails;
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username "+username);
//        if ("gray".equals(username)) {
//            return new User("gray", "$2a$12$g2wBIstQYhTFhwQc1DuR8.v9BvH5B0Ta4xompJzryECRrPvO9IH/O",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }

        final Customer customer = customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(customer.getEmail(), customer.getPassword(),
                    new ArrayList<>());

    }
}
