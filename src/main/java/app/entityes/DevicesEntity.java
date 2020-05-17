package app.entityes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "devices", schema = "public", catalog = "Smart_house")
public class DevicesEntity {
    private Long idDevice;
    private Long controller;
    private Long typeDevice;
    private Timestamp startDate;
    private Long workStatus;
    private String nameDevice;
    private String description;
    private ControllersEntity controllersByController;
    private TypeDevicesEntity typeDevicesByTypeDevice;
    private WorkStatusEntity workStatusByWorkStatus;
    private Collection<FunctionDevicesEntity> functionDevicesByIdDevice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device", nullable = false)
    public Long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Long idDevice) {
        this.idDevice = idDevice;
    }

    @Basic
    @Column(name = "controller", nullable = false)
    public Long getController() {
        return controller;
    }

    public void setController(Long controller) {
        this.controller = controller;
    }

    @Basic
    @Column(name = "type_device", nullable = false)
    public Long getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(Long typeDevice) {
        this.typeDevice = typeDevice;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "work_status", nullable = false)
    public Long getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Long workStatus) {
        this.workStatus = workStatus;
    }

    @Basic
    @Column(name = "name_device", nullable = false, length = 50)
    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 200)
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
        DevicesEntity that = (DevicesEntity) o;
        return Objects.equals(idDevice, that.idDevice) &&
                Objects.equals(controller, that.controller) &&
                Objects.equals(typeDevice, that.typeDevice) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(workStatus, that.workStatus) &&
                Objects.equals(nameDevice, that.nameDevice) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDevice, controller, typeDevice, startDate, workStatus, nameDevice, description);
    }

    @ManyToOne
    @JoinColumn(name = "controller", referencedColumnName = "id_controller", nullable = false,insertable = false, updatable = false)
    public ControllersEntity getControllersByController() {
        return controllersByController;
    }

    public void setControllersByController(ControllersEntity controllersByController) {
        this.controllersByController = controllersByController;
    }

    @ManyToOne
    @JoinColumn(name = "type_device", referencedColumnName = "id_type", nullable = false,insertable = false, updatable = false)
    public TypeDevicesEntity getTypeDevicesByTypeDevice() {
        return typeDevicesByTypeDevice;
    }

    public void setTypeDevicesByTypeDevice(TypeDevicesEntity typeDevicesByTypeDevice) {
        this.typeDevicesByTypeDevice = typeDevicesByTypeDevice;
    }

    @ManyToOne
    @JoinColumn(name = "work_status", referencedColumnName = "id_status", nullable = false,insertable = false, updatable = false)
    public WorkStatusEntity getWorkStatusByWorkStatus() {
        return workStatusByWorkStatus;
    }

    public void setWorkStatusByWorkStatus(WorkStatusEntity workStatusByWorkStatus) {
        this.workStatusByWorkStatus = workStatusByWorkStatus;
    }

    @OneToMany(mappedBy = "devicesByDevice")
    public Collection<FunctionDevicesEntity> getFunctionDevicesByIdDevice() {
        return functionDevicesByIdDevice;
    }

    public void setFunctionDevicesByIdDevice(Collection<FunctionDevicesEntity> functionDevicesByIdDevice) {
        this.functionDevicesByIdDevice = functionDevicesByIdDevice;
    }
}
