package app.dto;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class UserCreateDto {
    String login;
    String password;
    Timestamp registrationDate;
    String status;
    String role;
}
