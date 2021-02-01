package app.dto;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class UserDto {
    Integer id;
    String login;
    String password;
    Timestamp registrationDate;
    String status;
    String role;
}
