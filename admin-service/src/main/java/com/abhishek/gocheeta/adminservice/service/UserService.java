package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.UserDto;
import com.abhishek.gocheeta.commons.model.User;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:52
 */
public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto getUser(int id);

    UserDto removeUser(int id);

    List<UserDto> getUsers(String value);

}
