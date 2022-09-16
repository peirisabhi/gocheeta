package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByStatus(int status);
}
