package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
