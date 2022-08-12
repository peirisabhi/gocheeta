package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.UserDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.UserRepository;
import com.abhishek.gocheeta.adminservice.service.UserService;
import com.abhishek.gocheeta.commons.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:58
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {

        try{
            final User user = userDto.toEntity(User.class);
            user.setRegisteredAt(new Date());
            user.setStatus(1);

            return userRepository.save(user)
                    .toDto(UserDto.class);
        }catch (DataIntegrityViolationException e){
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(USER_ALREADY_EXISTS);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        final User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND));

        try{
            user.setFname(userDto.getFname());
            user.setLname(userDto.getLname());
            user.setCityId(userDto.getCityId());
            user.setEmail(userDto.getEmail());
            user.setGender(userDto.getGender());
            user.setNic(userDto.getNic());
            user.setUserRoleId(userDto.getUserRoleId());

            return userRepository.save(user)
                    .toDto(UserDto.class);
        }catch (DataIntegrityViolationException e){
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(USER_ALREADY_EXISTS);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public UserDto getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND))
                .toDto(UserDto.class);
    }

    @Override
    public UserDto removeUser(int id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND));

        try{
            user.setStatus(0);

            return userRepository.save(user)
                    .toDto(UserDto.class);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public List<UserDto> getUsers() {
//         userRepository.findAllByStatus(1)
//                .stream().map((user) -> {
//                    final UserDto userDto = user.toDto(UserDto.class);
//                    userDto.
//                });

         return null;

    }
}
