package app.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "functiondeviceview", schema = "public", catalog = "Smart_house")
public class FunctiondeviceviewEntity {
    @Expose()
    private Long idFunction;
    @Expose()
    private String nameFunction;
    @Expose()
    private String nameType;
    @Expose()
    private Long device;

    @Id
    @Basic
    @Column(name = "id_function", nullable = true)
    public Long getIdFunction() {
        return idFunction;
    }

    public void setIdFunction(Long idFunction) {
        this.idFunction = idFunction;
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
    @Column(name = "name_type", nullable = true, length = 50)
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Basic
    @Column(name = "device", nullable = true)
    public Long getDevice() {
        return device;
    }

    public void setDevice(Long device) {
        this.device = device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctiondeviceviewEntity that = (FunctiondeviceviewEntity) o;
        return Objects.equals(idFunction, that.idFunction) &&
                Objects.equals(nameFunction, that.nameFunction) &&
                Objects.equals(nameType, that.nameType) &&
                Objects.equals(device, that.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunction, nameFunction, nameType, device);
    }
}
