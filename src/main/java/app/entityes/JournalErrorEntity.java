package app.entityes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "journal_error", schema = "public", catalog = "Smart_house")
public class JournalErrorEntity {
    private Long idError;
    private Long typeError;
    private Long userRequest;
    private Long functionDevices;
    private Timestamp dateError;
    private String description;
    private TypeErrorEntity typeErrorByTypeError;
    private JournalUserRequestEntity journalUserRequestByUserRequest;
    private FunctionDevicesEntity functionDevicesByFunctionDevices;

    @Id
    @Column(name = "id_error", nullable = false)
    public Long getIdError() {
        return idError;
    }

    public void setIdError(Long idError) {
        this.idError = idError;
    }

    @Basic
    @Column(name = "type_error", nullable = false)
    public Long getTypeError() {
        return typeError;
    }

    public void setTypeError(Long typeError) {
        this.typeError = typeError;
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
    @Column(name = "function_devices", nullable = false)
    public Long getFunctionDevices() {
        return functionDevices;
    }

    public void setFunctionDevices(Long functionDevices) {
        this.functionDevices = functionDevices;
    }

    @Basic
    @Column(name = "date_error", nullable = false)
    public Timestamp getDateError() {
        return dateError;
    }

    public void setDateError(Timestamp dateError) {
        this.dateError = dateError;
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
        JournalErrorEntity that = (JournalErrorEntity) o;
        return Objects.equals(idError, that.idError) &&
                Objects.equals(typeError, that.typeError) &&
                Objects.equals(userRequest, that.userRequest) &&
                Objects.equals(functionDevices, that.functionDevices) &&
                Objects.equals(dateError, that.dateError) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idError, typeError, userRequest, functionDevices, dateError, description);
    }

    @ManyToOne
    @JoinColumn(name = "type_error", referencedColumnName = "id_error", nullable = false)
    public TypeErrorEntity getTypeErrorByTypeError() {
        return typeErrorByTypeError;
    }

    public void setTypeErrorByTypeError(TypeErrorEntity typeErrorByTypeError) {
        this.typeErrorByTypeError = typeErrorByTypeError;
    }

    @ManyToOne
    @JoinColumn(name = "user_request", referencedColumnName = "id_request")
    public JournalUserRequestEntity getJournalUserRequestByUserRequest() {
        return journalUserRequestByUserRequest;
    }

    public void setJournalUserRequestByUserRequest(JournalUserRequestEntity journalUserRequestByUserRequest) {
        this.journalUserRequestByUserRequest = journalUserRequestByUserRequest;
    }

    @ManyToOne
    @JoinColumn(name = "function_devices", referencedColumnName = "id_function", nullable = false)
    public FunctionDevicesEntity getFunctionDevicesByFunctionDevices() {
        return functionDevicesByFunctionDevices;
    }

    public void setFunctionDevicesByFunctionDevices(FunctionDevicesEntity functionDevicesByFunctionDevices) {
        this.functionDevicesByFunctionDevices = functionDevicesByFunctionDevices;
    }
}
