package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.BookingStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingStatusHistoryRepository extends JpaRepository<BookingStatusHistory, Integer> {
}
