package app.dto;

import lombok.Value;

import java.util.Date;

@Value
public class UserDto {
    Integer id;
    String login;
    Date registrationDate;
    String status;
    String role;
}
