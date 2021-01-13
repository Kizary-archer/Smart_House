package app.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

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
    private String status;
    @Basic
    @Column(name = "description", length = 200)
    private String description;

}
