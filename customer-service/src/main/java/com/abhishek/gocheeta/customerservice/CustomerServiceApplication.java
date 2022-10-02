package com.abhishek.gocheeta.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
@EntityScan(basePackages = "com.abhishek.gocheeta.commons.model")
public class CustomerServiceApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	public void run(String... args) {

		System.out.println("Sending Email...");

		try {

			sendEmail();
			//sendEmailWithAttachment();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

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
		helper.setTo("1@gmail.com");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		//helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		javaMailSender.send(msg);

	}
}
