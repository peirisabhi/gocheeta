package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findAllByCityIdAndAvailabilityAndVehicleCategoryId(int cityId,
                                                                     boolean availability,
                                                                     int vehicleCategoryId);

    List<Vehicle> findAllByStatus(int status);
}
