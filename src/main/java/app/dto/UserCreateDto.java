package app.dto;

import com.sun.istack.NotNull;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Value
public class UserCreateDto {
    String login;
    String password;
    Timestamp registrationDate;
    String status;
    String role;
}
