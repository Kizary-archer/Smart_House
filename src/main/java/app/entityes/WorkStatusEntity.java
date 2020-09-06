package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "work_status", schema = "public", catalog = "Smart_house")
public class WorkStatusEntity {
    private Long idStatus;
    private String nameStatus;
    private String description;
    private Collection<ControllersEntity> controllersByIdStatus;
    private Collection<DevicesEntity> devicesByIdStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status", nullable = false)
    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "name_status", nullable = false, length = 50)
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
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
        WorkStatusEntity that = (WorkStatusEntity) o;
        return Objects.equals(idStatus, that.idStatus) &&
                Objects.equals(nameStatus, that.nameStatus) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStatus, nameStatus, description);
    }

    @OneToMany(mappedBy = "workStatusByWorkStatus")
    public Collection<ControllersEntity> getControllersByIdStatus() {
        return controllersByIdStatus;
    }

    public void setControllersByIdStatus(Collection<ControllersEntity> controllersByIdStatus) {
        this.controllersByIdStatus = controllersByIdStatus;
    }

    @OneToMany(mappedBy = "workStatusByWorkStatus")
    public Collection<DevicesEntity> getDevicesByIdStatus() {
        return devicesByIdStatus;
    }

    public void setDevicesByIdStatus(Collection<DevicesEntity> devicesByIdStatus) {
        this.devicesByIdStatus = devicesByIdStatus;
    }
}
