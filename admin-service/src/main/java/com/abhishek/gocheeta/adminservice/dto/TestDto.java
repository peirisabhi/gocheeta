package com.abhishek.gocheeta.adminservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-31
 * Time: 14:01
 */
@Getter
@Setter
@ToString
@Data
public class TestDto {

    private MultipartFile file;

    private String name;
}
