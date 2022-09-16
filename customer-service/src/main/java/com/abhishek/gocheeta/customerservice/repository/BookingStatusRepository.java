package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, Integer> {
}
