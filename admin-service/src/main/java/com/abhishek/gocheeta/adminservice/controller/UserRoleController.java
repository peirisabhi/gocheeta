package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.UserRoleDto;
import com.abhishek.gocheeta.adminservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user-role")
@Slf4j
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping
    public ResponseEntity<List<UserRoleDto>> getUserRoles(){
        return ResponseEntity.ok(userRoleService.getUserRoles());
    }


    @GetMapping("{roleId}")
    public ResponseEntity<UserRoleDto> getUserRole(@PathVariable(value = "roleId") int roleId){
        return ResponseEntity.ok(userRoleService.getUserRole(roleId));
    }

}
