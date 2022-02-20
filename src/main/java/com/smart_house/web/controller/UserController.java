package com.smart_house.web.controller;

import com.smart_house.dto.UserDto;
import com.smart_house.service.UserService;
import com.smart_house.validation.group.UserCreate;
import com.smart_house.validation.group.UserUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable @PositiveOrZero Integer id) {
        return ResponseEntity.ok()
                .body(userService.getUserById(id));
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UserDto> getUserByLogin(@PathVariable String login) {
        return ResponseEntity.ok()
                .body(userService.getUserByLogin(login));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Validated(UserCreate.class) @RequestBody UserDto userDto) {
        return userService.createUser(userDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@Validated(UserUpdate.class) @RequestBody UserDto userDto) {
        return userService.updateUser(userDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
