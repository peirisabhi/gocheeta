package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByStatus(int status);

}
