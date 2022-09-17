package com.abhishek.gocheeta.customerservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-17
 * Time: 09:31
 */
@Getter
@Setter
@ToString
public class LoginRequestDto implements Serializable {

    private String username;

    private String password;
}
