package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
