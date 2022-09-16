package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByStatus(boolean status);

}
