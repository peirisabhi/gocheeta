package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


    List<Vehicle> findAllByStatus(int status);
}
