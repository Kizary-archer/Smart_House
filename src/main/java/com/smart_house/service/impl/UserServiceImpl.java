package com.smart_house.service.impl;

import com.smart_house.constants.MessageConstants;
import com.smart_house.dto.UserDto;
import com.smart_house.exception.EntityNotFoundException;
import com.smart_house.mapper.UserMapper;
import com.smart_house.repository.RoleRepository;
import com.smart_house.repository.StatusRepository;
import com.smart_house.repository.UserRepository;
import com.smart_house.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .map(userMapper::map).orElseThrow(() -> {
                    log.error("User with login " + login + " has not been found");
                    return new EntityNotFoundException(MessageConstants.USER_LOGIN_NOT_FOUND, "login");
                });
    }

    @Override
    public UserDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::map).orElseThrow(() -> {
                    log.error("User with id " + id + " has not been found");
                    return new EntityNotFoundException(MessageConstants.USER_ID_NOT_FOUND, "id");
                });
    }

    @Override
    public List<UserDto> getAllUsers() {
        return Optional.of(userRepository.findAll())
                .map(userMapper::map).orElseThrow(() -> {
                    log.error("Users have not been found");
                    return new EntityNotFoundException(MessageConstants.USERS_NOT_FOUND, "id");
                });
    }


    @Override
    @Transactional
    public Optional<UserDto> createUser(UserDto userDto) {
        return roleRepository.findByRole(userDto.getRole())
                .flatMap(userRole -> statusRepository.findByStatus(userDto.getStatus())
                        .map(userStatus -> userMapper.map(userDto)
                                .setPassword(passwordEncoder.encode(userDto.getPassword()))
                                .setRole(userRole)
                                .setStatus(userStatus)
                                .setRegistrationDate(new Timestamp(System.currentTimeMillis()))))
                .map(userRepository::save)
                .map(userMapper::map);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<UserDto> updateUser(UserDto userDto) {
        userRepository.findById(userDto.getId()).orElseThrow(() -> {
            log.error("Users have not been found");
            return new EntityNotFoundException(MessageConstants.USER_ID_NOT_FOUND, "id");
        });
        return roleRepository.findByRole(userDto.getRole())
                .flatMap(userRole -> statusRepository.findByStatus(userDto.getStatus())
                        .map(userStatus -> userMapper.map(userDto)
                                .setPassword(passwordEncoder.encode(userDto.getPassword()))
                                .setRole(userRole)
                                .setStatus(userStatus)
                                .setRegistrationDate(new Timestamp(System.currentTimeMillis()))))
                .map(userRepository::save)
                .map(userMapper::map);
    }
}
