package app.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode
@Getter
@Entity
@Table(name = "user_status")
public class UserStatus {
    @Id
    @Column(name = "id_user_status", nullable = false)
    private Integer idUserStatus;
    @Basic
    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;
    @Basic
    @Column(name = "description", length = 200)
    private String description;

}
