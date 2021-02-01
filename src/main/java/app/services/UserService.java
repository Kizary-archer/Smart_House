package app.services;

import app.dto.UserCreateDto;
import app.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {


    /**
     * @param login логин пользвателя
     * @return сущьность пользователя
     */
    Optional<UserDto> getUserByLogin(String login);

    Optional<UserDto> getUserById(Integer id);

    Optional<List<UserDto>> getAllUsers();

    Optional<UserDto> createUser(UserCreateDto userCreateDto);

    void deleteUserById(Integer id);

    Optional<UserDto> updateUser(UserDto userDto);
}
