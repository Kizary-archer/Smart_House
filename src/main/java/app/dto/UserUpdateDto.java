package app.dto;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class UserUpdateDto {
    Integer id;
    String login;
    String password;
    Timestamp registrationDate;
    String status;
    String role;
}
