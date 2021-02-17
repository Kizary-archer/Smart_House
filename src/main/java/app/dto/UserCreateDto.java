package app.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Value
public class UserCreateDto {
    @NotBlank(message = "login must not be empty")
    String login;
    @NotBlank(message = "password must not be empty")
    String password;
    @NotBlank
    String status;
    @NotBlank
    String role;
}
