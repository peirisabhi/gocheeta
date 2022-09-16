package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findAllByStatus(int status);

}
