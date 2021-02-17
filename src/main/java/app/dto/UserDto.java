package app.dto;

import app.group.UserCreate;
import app.group.UserUpdate;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Value
public class UserDto {
    @Null(groups = UserCreate.class,message = "id must be null")
    @NotNull(groups = UserUpdate.class,message = "id must not be null")
    Integer id;
    @NotBlank(message = "login must not be empty")
    String login;
    @NotBlank(message = "password must not be empty")
    String password;
    @NotBlank
    String status;
    @NotBlank
    String role;
}
