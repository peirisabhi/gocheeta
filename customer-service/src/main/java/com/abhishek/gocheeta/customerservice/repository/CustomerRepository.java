package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByStatus(int status);

    Optional<Customer> findByEmail(String email);
}
