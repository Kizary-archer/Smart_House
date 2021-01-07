package app.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_devices", schema = "public", catalog = "Smart_house")
public class TypeDevicesEntity {
    private Long idType;
    private String nameType;
    private String description;
    private Collection<DevicesEntity> devicesByIdType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "name_type", nullable = false, length = 50)
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
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
        TypeDevicesEntity that = (TypeDevicesEntity) o;
        return Objects.equals(idType, that.idType) &&
                Objects.equals(nameType, that.nameType) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, nameType, description);
    }

    @OneToMany(mappedBy = "typeDevicesByTypeDevice")
    public Collection<DevicesEntity> getDevicesByIdType() {
        return devicesByIdType;
    }

    public void setDevicesByIdType(Collection<DevicesEntity> devicesByIdType) {
        this.devicesByIdType = devicesByIdType;
    }
}
