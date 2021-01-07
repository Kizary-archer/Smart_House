package app.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal_event_view", schema = "public", catalog = "Smart_house")
public class JournalEventViewEntity {
    @Expose()
    private Long idEvent;
    @Expose()
    private String nameEvent;
    @Expose()
    private String nameFunction;
    @Expose()
    private Long userRequest;
    @Expose()
    private Timestamp dateEvent;
    @Expose()
    private Long data;

    @Id
    @Basic
    @Column(name = "id_event", nullable = true)
    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
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
    @Column(name = "name_function", nullable = true, length = 50)
    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }

    @Basic
    @Column(name = "user_request", nullable = true)
    public Long getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(Long userRequest) {
        this.userRequest = userRequest;
    }

    @Basic
    @Column(name = "date_event", nullable = true)
    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Basic
    @Column(name = "data", nullable = true)
    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalEventViewEntity that = (JournalEventViewEntity) o;
        return Objects.equals(idEvent, that.idEvent) &&
                Objects.equals(nameEvent, that.nameEvent) &&
                Objects.equals(nameFunction, that.nameFunction) &&
                Objects.equals(userRequest, that.userRequest) &&
                Objects.equals(dateEvent, that.dateEvent) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, nameEvent, nameFunction, userRequest, dateEvent, data);
    }
}
