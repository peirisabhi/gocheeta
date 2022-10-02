package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-10-02
 * Time: 11:54
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
@CrossOrigin
public class TestController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping()
    public ResponseEntity<String> getCustomer() {
        System.out.println("Sending Email...");

        try {

//            sendEmail();
            sendEmailWithAttachment();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

        return null;
    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("abhishekpeiris9@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("abhishekpeiris9@gmail.com");
        helper.setFrom(new InternetAddress("ashvindi999@gmail.com", "NoReply-GoCheeta"));

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html

        File f = new File("/Users/abhishekpeiris/icbt/advanced-programming/gocheeta/customer-service/src/main/resources/templates/profile-verify.html");
        String message = "Your Account Is Approved!!";
        if(f.exists()) {
            message = FileUtils.readFileToString(f, StandardCharsets.UTF_8).replace("ABHISHEK", "ABCDEF SSDD");
        }

        helper.setText(message, true);

//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}
