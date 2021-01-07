package app.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_status", schema = "public", catalog = "Smart_house")
public class UserStatusEntity {
    private Long idUserStatus;
    private String statusName;
    private String description;
    private Collection<UsersEntity> usersByIdUserStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_status", nullable = false)
    public Long getIdUserStatus() {
        return idUserStatus;
    }

    public void setIdUserStatus(Long idUserStatus) {
        this.idUserStatus = idUserStatus;
    }

    @Basic
    @Column(name = "status_name", nullable = false, length = 50)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStatusEntity that = (UserStatusEntity) o;
        return Objects.equals(idUserStatus, that.idUserStatus) &&
                Objects.equals(statusName, that.statusName) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserStatus, statusName, description);
    }

    @OneToMany(mappedBy = "userStatusByStatus")
    public Collection<UsersEntity> getUsersByIdUserStatus() {
        return usersByIdUserStatus;
    }

    public void setUsersByIdUserStatus(Collection<UsersEntity> usersByIdUserStatus) {
        this.usersByIdUserStatus = usersByIdUserStatus;
    }
}
