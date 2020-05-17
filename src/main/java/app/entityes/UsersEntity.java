package app.entityes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "Smart_house")
public class UsersEntity {
    private Long idUser;
    private String login;
    private String password;
    private Long role;
    private Timestamp registrationDate;
    private Long status;
    private Collection<ControllersEntity> controllersByIdUser;
    private Collection<GroupFunctionEntity> groupFunctionsByIdUser;
    private Collection<JournalUserRequestEntity> journalUserRequestsByIdUser;
    private UserRoleEntity userRoleByRole;
    private UserStatusEntity userStatusByStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Basic
    @Column(name = "registration_date", nullable = false)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, password, role, registrationDate, status);
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<ControllersEntity> getControllersByIdUser() {
        return controllersByIdUser;
    }

    public void setControllersByIdUser(Collection<ControllersEntity> controllersByIdUser) {
        this.controllersByIdUser = controllersByIdUser;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<GroupFunctionEntity> getGroupFunctionsByIdUser() {
        return groupFunctionsByIdUser;
    }

    public void setGroupFunctionsByIdUser(Collection<GroupFunctionEntity> groupFunctionsByIdUser) {
        this.groupFunctionsByIdUser = groupFunctionsByIdUser;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<JournalUserRequestEntity> getJournalUserRequestsByIdUser() {
        return journalUserRequestsByIdUser;
    }

    public void setJournalUserRequestsByIdUser(Collection<JournalUserRequestEntity> journalUserRequestsByIdUser) {
        this.journalUserRequestsByIdUser = journalUserRequestsByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id_role", nullable = false,insertable = false, updatable = false)
    public UserRoleEntity getUserRoleByRole() {
        return userRoleByRole;
    }

    public void setUserRoleByRole(UserRoleEntity userRoleByRole) {
        this.userRoleByRole = userRoleByRole;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id_user_status", nullable = false,insertable = false, updatable = false)
    public UserStatusEntity getUserStatusByStatus() {
        return userStatusByStatus;
    }

    public void setUserStatusByStatus(UserStatusEntity userStatusByStatus) {
        this.userStatusByStatus = userStatusByStatus;
    }
}
