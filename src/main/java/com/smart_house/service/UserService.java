package com.smart_house.service;

import com.smart_house.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {


    /**
     * @param login логин пользвателя
     * @return сущьность пользователя
     */
    UserDto getUserByLogin(String login);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    Optional<UserDto> createUser(UserDto userDto);

    void deleteUserById(Integer id);

    Optional<UserDto> updateUser(UserDto userDto);
}
