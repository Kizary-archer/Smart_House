package app.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "userview", schema = "public", catalog = "Smart_house")
public class UserviewEntity {
    @Expose()
    private Long idUser;
    @Expose()
    private String login;
    @Expose()
    private Timestamp registrationDate;
    @Expose()
    private String statusName;
    @Expose()
    private String nameRole;

    @Id
    @Basic
    @Column(name = "id_user", nullable = true)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "registration_date", nullable = true)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "status_name", nullable = true, length = 50)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Basic
    @Column(name = "name_role", nullable = true, length = 50)
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserviewEntity that = (UserviewEntity) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(statusName, that.statusName) &&
                Objects.equals(nameRole, that.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, registrationDate, statusName, nameRole);
    }
}
