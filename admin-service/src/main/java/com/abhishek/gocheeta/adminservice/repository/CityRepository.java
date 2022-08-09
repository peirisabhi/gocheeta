package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
