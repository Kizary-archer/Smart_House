package com.smart_house.dto;

import com.smart_house.validation.group.UserCreate;
import com.smart_house.validation.group.UserUpdate;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Dto пользователя
 */
@Value
public class UserDto {
    @Null(groups = UserCreate.class,message = "id must be null")
    @NotNull(groups = UserUpdate.class,message = "id must not be null")
    Integer id;
    @NotBlank(message = "login must not be empty")
    String login;
    @NotBlank(message = "password must not be empty",groups = {UserCreate.class,UserUpdate.class})
    String password;
    @NotBlank
    String status;
    @NotBlank
    String role;
}
