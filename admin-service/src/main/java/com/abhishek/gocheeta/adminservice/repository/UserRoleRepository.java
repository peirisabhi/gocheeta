package com.abhishek.gocheeta.adminservice.repository;

import com.abhishek.gocheeta.commons.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByStatus(boolean status);

}
