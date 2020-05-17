package app.entityes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "journal_user_request", schema = "public", catalog = "Smart_house")
public class JournalUserRequestEntity {
    private Long idRequest;
    private Timestamp dateRequest;
    private Long user;
    private Boolean statusRequest;
    private Collection<JournalErrorEntity> journalErrorsByIdRequest;
    private Collection<JournalEventEntity> journalEventsByIdRequest;
    private UsersEntity usersByUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request", nullable = false)
    public Long getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
    }

    @Basic
    @Column(name = "date_request", nullable = false)
    public Timestamp getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Timestamp dateRequest) {
        this.dateRequest = dateRequest;
    }

    @Basic
    @Column(name = "user", nullable = false)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Basic
    @Column(name = "status_request", nullable = false)
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
        JournalUserRequestEntity that = (JournalUserRequestEntity) o;
        return Objects.equals(idRequest, that.idRequest) &&
                Objects.equals(dateRequest, that.dateRequest) &&
                Objects.equals(user, that.user) &&
                Objects.equals(statusRequest, that.statusRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRequest, dateRequest, user, statusRequest);
    }

    @OneToMany(mappedBy = "journalUserRequestByUserRequest")
    public Collection<JournalErrorEntity> getJournalErrorsByIdRequest() {
        return journalErrorsByIdRequest;
    }

    public void setJournalErrorsByIdRequest(Collection<JournalErrorEntity> journalErrorsByIdRequest) {
        this.journalErrorsByIdRequest = journalErrorsByIdRequest;
    }

    @OneToMany(mappedBy = "journalUserRequestByUserRequest")
    public Collection<JournalEventEntity> getJournalEventsByIdRequest() {
        return journalEventsByIdRequest;
    }

    public void setJournalEventsByIdRequest(Collection<JournalEventEntity> journalEventsByIdRequest) {
        this.journalEventsByIdRequest = journalEventsByIdRequest;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id_user", nullable = false,insertable = false, updatable = false)
    public UsersEntity getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(UsersEntity usersByUser) {
        this.usersByUser = usersByUser;
    }
}
