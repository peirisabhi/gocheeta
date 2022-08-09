package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Integer> {
}
