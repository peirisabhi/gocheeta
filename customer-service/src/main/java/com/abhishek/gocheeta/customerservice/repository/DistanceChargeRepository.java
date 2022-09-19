package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.DistanceCharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistanceChargeRepository extends JpaRepository<DistanceCharge, Integer> {

    List<DistanceCharge> findAllByVehicleCategoryId(int vehicleCategoryId);

}
