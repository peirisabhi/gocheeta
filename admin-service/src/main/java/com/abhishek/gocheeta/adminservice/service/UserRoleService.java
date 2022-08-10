package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.UserRoleDto;

import java.util.List;

public interface UserRoleService {

    List<UserRoleDto> getUserRoles();

    UserRoleDto getUserRole(int id);
}
