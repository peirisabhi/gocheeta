package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.LicenceTypeDto;
import com.abhishek.gocheeta.adminservice.dto.UserRoleDto;
import com.abhishek.gocheeta.adminservice.service.LicenceTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 14:27
 */
@RestController
@RequestMapping(value = "/licence-type")
@Slf4j
public class LicenceTypeController {

    @Autowired
    LicenceTypeService licenceTypeService;


    @GetMapping
    public ResponseEntity<List<LicenceTypeDto>> getLicenceTypes(){
        return ResponseEntity.ok(licenceTypeService.getLicenceTypes());
    }


    @GetMapping("{licenceTypeId}")
    public ResponseEntity<LicenceTypeDto> getLicenceType(@PathVariable(value = "licenceTypeId") int licenceTypeId){
        return ResponseEntity.ok(licenceTypeService.getLicenceType(licenceTypeId));
    }
}
