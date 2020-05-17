package app.entityes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal_event", schema = "public", catalog = "Smart_house")
public class JournalEventEntity {
    private Long idEvent;
    private Long typeEvent;
    private Long functionDevices;
    private Long data;
    private Timestamp dateEvent;
    private Long userRequest;
    private TypeEventEntity typeEventByTypeEvent;
    private FunctionDevicesEntity functionDevicesByFunctionDevices;
    private JournalUserRequestEntity journalUserRequestByUserRequest;

    @Id
    @Column(name = "id_event", nullable = false)
    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "type_event", nullable = false)
    public Long getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(Long typeEvent) {
        this.typeEvent = typeEvent;
    }

    @Basic
    @Column(name = "function_devices", nullable = false)
    public Long getFunctionDevices() {
        return functionDevices;
    }

    public void setFunctionDevices(Long functionDevices) {
        this.functionDevices = functionDevices;
    }

    @Basic
    @Column(name = "data", nullable = true)
    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Basic
    @Column(name = "date_event", nullable = false)
    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Basic
    @Column(name = "user_request", nullable = true)
    public Long getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(Long userRequest) {
        this.userRequest = userRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalEventEntity that = (JournalEventEntity) o;
        return Objects.equals(idEvent, that.idEvent) &&
                Objects.equals(typeEvent, that.typeEvent) &&
                Objects.equals(functionDevices, that.functionDevices) &&
                Objects.equals(data, that.data) &&
                Objects.equals(dateEvent, that.dateEvent) &&
                Objects.equals(userRequest, that.userRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, typeEvent, functionDevices, data, dateEvent, userRequest);
    }

    @ManyToOne
    @JoinColumn(name = "type_event", referencedColumnName = "id_event", nullable = false)
    public TypeEventEntity getTypeEventByTypeEvent() {
        return typeEventByTypeEvent;
    }

    public void setTypeEventByTypeEvent(TypeEventEntity typeEventByTypeEvent) {
        this.typeEventByTypeEvent = typeEventByTypeEvent;
    }

    @ManyToOne
    @JoinColumn(name = "function_devices", referencedColumnName = "id_function", nullable = false)
    public FunctionDevicesEntity getFunctionDevicesByFunctionDevices() {
        return functionDevicesByFunctionDevices;
    }

    public void setFunctionDevicesByFunctionDevices(FunctionDevicesEntity functionDevicesByFunctionDevices) {
        this.functionDevicesByFunctionDevices = functionDevicesByFunctionDevices;
    }

    @ManyToOne
    @JoinColumn(name = "user_request", referencedColumnName = "id_request")
    public JournalUserRequestEntity getJournalUserRequestByUserRequest() {
        return journalUserRequestByUserRequest;
    }

    public void setJournalUserRequestByUserRequest(JournalUserRequestEntity journalUserRequestByUserRequest) {
        this.journalUserRequestByUserRequest = journalUserRequestByUserRequest;
    }
}
