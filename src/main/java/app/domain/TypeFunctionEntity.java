package app.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "type_function", schema = "public", catalog = "Smart_house")
public class TypeFunctionEntity {
    private Long idType;
    private String nameType;
    private String description;
    private Boolean range;
    private Collection<FunctionDevicesEntity> functionDevicesByIdType;

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

    @Basic
    @Column(name = "range", nullable = false)
    public Boolean getRange() {
        return range;
    }

    public void setRange(Boolean range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeFunctionEntity that = (TypeFunctionEntity) o;
        return Objects.equals(idType, that.idType) &&
                Objects.equals(nameType, that.nameType) &&
                Objects.equals(description, that.description) &&
                Objects.equals(range, that.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, nameType, description, range);
    }

    @OneToMany(mappedBy = "typeFunctionByTypeFunction")
    public Collection<FunctionDevicesEntity> getFunctionDevicesByIdType() {
        return functionDevicesByIdType;
    }

    public void setFunctionDevicesByIdType(Collection<FunctionDevicesEntity> functionDevicesByIdType) {
        this.functionDevicesByIdType = functionDevicesByIdType;
    }
}
