package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.UserRoleDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.UserRoleRepository;
import com.abhishek.gocheeta.adminservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.USER_ROLE_NOT_FOUND;

@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleDto> getUserRoles() {
        try {
            return userRoleRepository.findAllByStatus(true)
                    .stream().map(userRole -> userRole.toDto(UserRoleDto.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public UserRoleDto getUserRole(int id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_ROLE_NOT_FOUND))
                .toDto(UserRoleDto.class);

    }
}
