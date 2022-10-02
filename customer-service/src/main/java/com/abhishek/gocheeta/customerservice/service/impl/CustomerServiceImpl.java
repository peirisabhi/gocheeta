package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.Customer;
import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.customerservice.exception.GeneralException;
import com.abhishek.gocheeta.customerservice.repository.CustomerRepository;
import com.abhishek.gocheeta.customerservice.service.CustomerService;
import com.abhishek.gocheeta.customerservice.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-16
 * Time: 11:09
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        try {
            final Customer customer = customerDto.toEntity(Customer.class);
            if(customerDto.getDob() != null && !customerDto.getDob().equals("")){
                customer.setDob(DateUtil.getDate(customerDto.getDob()));
            }
            customer.setRegisteredAt(new Date());
            customer.setStatus(1);
            customer.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));

            customerDto =  customerRepository.save(customer)
                    .toDto(CustomerDto.class);

            sendEmailWithAttachment(customerDto.getFname().concat(" ").concat(customerDto.getLname()), customerDto.getEmail());

            return customerDto;

        } catch (ParseException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new GeneralException("Invalid Date Format");
        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
            throw new DuplicateDataFoundException(CUSTOMER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
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
    public CustomerDto getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND))
                .toDto(CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException(CUSTOMER_NOT_FOUND))
                .toDto(CustomerDto.class);
    }

    void sendEmailWithAttachment(String name, String to) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to);
        helper.setFrom(new InternetAddress("ashvindi999@gmail.com", "NoReply-GoCheeta"));

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html

        File f = new File("/Users/abhishekpeiris/icbt/advanced-programming/gocheeta/customer-service/src/main/resources/templates/profile-verify.html");
        String message = "Your Account Is Approved!!";
        if(f.exists()) {
            message = FileUtils.readFileToString(f, StandardCharsets.UTF_8).replace("ABHISHEK", name);
        }

        helper.setText(message, true);

//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
        System.out.println("email sending");
        javaMailSender.send(msg);
        System.out.println("email sent");

    }
}
