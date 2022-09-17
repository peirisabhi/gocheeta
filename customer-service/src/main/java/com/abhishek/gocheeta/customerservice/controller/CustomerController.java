package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import com.abhishek.gocheeta.customerservice.dto.LoginRequestDto;
import com.abhishek.gocheeta.customerservice.dto.LoginResponseDto;
import com.abhishek.gocheeta.customerservice.security.JwtTokenUtil;
import com.abhishek.gocheeta.customerservice.service.CustomerService;
import com.abhishek.gocheeta.customerservice.service.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> saveCustomer(
            @RequestBody CustomerDto customerDto) {
        log.info(customerDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.saveCustomer(customerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto loginRequestDto) throws Exception{
        log.info(loginRequestDto.toString());

//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
//
//
//        log.info("------- 1 ------");
////        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        log.info("------- 2 ------");
//
//        final String token = jwtTokenUtil.generateToken(new UserDetailsImpl(1,"abc","asa", "asa", "asa"));
//
//        log.info("Token --- "+ token);

        authenticate(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        System.out.println("----- 1 -------");

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequestDto.getUsername());

        System.out.println("-------- 2 --------- " + userDetails.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println("token -- " + token);

        final LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setJwtToken(token);

        return ResponseEntity.ok(loginResponseDto);
    }


    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<CustomerDto> updateCustomer(
            @RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.updateCustomer(customerDto));
    }


    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomerDto(
            @PathVariable(value = "customerId/**") int customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @GetMapping()
    public ResponseEntity<CustomerDto> getCustomer() {
        return ResponseEntity.ok(customerService.getCustomer(1));
    }


}
