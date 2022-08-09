package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
