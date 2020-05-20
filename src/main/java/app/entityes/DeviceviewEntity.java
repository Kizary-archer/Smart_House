package app.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deviceview", schema = "public", catalog = "Smart_house")
public class DeviceviewEntity {
    private Long idDevice;
    private String nameDevice;
    private String nameController;
    private String nameType;
    private String nameStatus;

    @Id
    @Basic
    @Column(name = "id_device", nullable = true)
    public Long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Long idDevice) {
        this.idDevice = idDevice;
    }

    @Basic
    @Column(name = "name_device", nullable = true, length = 50)
    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    @Basic
    @Column(name = "name_controller", nullable = true, length = 50)
    public String getNameController() {
        return nameController;
    }

    public void setNameController(String nameController) {
        this.nameController = nameController;
    }

    @Basic
    @Column(name = "name_type", nullable = true, length = 50)
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Basic
    @Column(name = "name_status", nullable = true, length = 50)
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceviewEntity that = (DeviceviewEntity) o;
        return Objects.equals(idDevice, that.idDevice) &&
                Objects.equals(nameDevice, that.nameDevice) &&
                Objects.equals(nameController, that.nameController) &&
                Objects.equals(nameType, that.nameType) &&
                Objects.equals(nameStatus, that.nameStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDevice, nameDevice, nameController, nameType, nameStatus);
    }
}
