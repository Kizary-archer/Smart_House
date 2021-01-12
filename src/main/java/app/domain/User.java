package app.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
public class User {
    @Id
    private Integer idUser;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "registration_date")
    private Timestamp registrationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private UserStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private UserRole role;
}
