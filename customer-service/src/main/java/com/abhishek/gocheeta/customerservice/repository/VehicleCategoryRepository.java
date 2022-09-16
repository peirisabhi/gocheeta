package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Integer> {

    List<VehicleCategory> findAllByStatus(boolean status);

}
