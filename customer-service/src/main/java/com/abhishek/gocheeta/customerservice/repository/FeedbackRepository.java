package com.abhishek.gocheeta.customerservice.repository;

import com.abhishek.gocheeta.commons.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
