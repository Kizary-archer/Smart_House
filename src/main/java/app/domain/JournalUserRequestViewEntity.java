package app.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal_user_request_view", schema = "public", catalog = "Smart_house")
public class JournalUserRequestViewEntity {
    @Expose()
    private Long idRequest;
    @Expose()
    private Long idUser;
    @Expose()
    private String login;
    @Expose()
    private String nameEvent;
    @Expose()
    private String nameError;
    @Expose()
    private Timestamp dateRequest;
    @Expose()
    private Boolean statusRequest;

    @Id
    @Basic
    @Column(name = "id_request", nullable = true)
    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

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
    @Column(name = "name_event", nullable = true, length = 50)
    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    @Basic
    @Column(name = "name_error", nullable = true, length = 50)
    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    @Basic
    @Column(name = "date_request", nullable = true)
    public Timestamp getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Timestamp dateRequest) {
        this.dateRequest = dateRequest;
    }

    @Basic
    @Column(name = "status_request", nullable = true)
    public Boolean getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(Boolean statusRequest) {
        this.statusRequest = statusRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalUserRequestViewEntity that = (JournalUserRequestViewEntity) o;
        return Objects.equals(idRequest, that.idRequest) &&
                Objects.equals(idUser, that.idUser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(nameEvent, that.nameEvent) &&
                Objects.equals(nameError, that.nameError) &&
                Objects.equals(dateRequest, that.dateRequest) &&
                Objects.equals(statusRequest, that.statusRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRequest, idUser, login, nameEvent, nameError, dateRequest, statusRequest);
    }
}
