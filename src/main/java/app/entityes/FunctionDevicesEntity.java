package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "function_devices", schema = "public", catalog = "Smart_house")
public class FunctionDevicesEntity {
    private Long idFunction;
    private Long device;
    private Long typeFunction;
    private String nameFunction;
    private String description;
    private Long data;
    private Long minData;
    private Long maxData;
    private DevicesEntity devicesByDevice;
    private TypeFunctionEntity typeFunctionByTypeFunction;
    private Collection<FunctionsGroupsEntity> functionsGroupsByIdFunction;
    private Collection<JournalErrorEntity> journalErrorsByIdFunction;
    private Collection<JournalEventEntity> journalEventsByIdFunction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_function", nullable = false)
    public Long getIdFunction() {
        return idFunction;
    }

    public void setIdFunction(Long idFunction) {
        this.idFunction = idFunction;
    }

    @Basic
    @Column(name = "device", nullable = false)
    public Long getDevice() {
        return device;
    }

    public void setDevice(Long device) {
        this.device = device;
    }

    @Basic
    @Column(name = "type_function", nullable = false)
    public Long getTypeFunction() {
        return typeFunction;
    }

    public void setTypeFunction(Long typeFunction) {
        this.typeFunction = typeFunction;
    }

    @Basic
    @Column(name = "name_function", nullable = false, length = 50)
    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
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
    @Column(name = "data", nullable = true)
    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    @Basic
    @Column(name = "min_data", nullable = true)
    public Long getMinData() {
        return minData;
    }

    public void setMinData(Long minData) {
        this.minData = minData;
    }

    @Basic
    @Column(name = "max_data", nullable = true)
    public Long getMaxData() {
        return maxData;
    }

    public void setMaxData(Long maxData) {
        this.maxData = maxData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionDevicesEntity that = (FunctionDevicesEntity) o;
        return Objects.equals(idFunction, that.idFunction) &&
                Objects.equals(device, that.device) &&
                Objects.equals(typeFunction, that.typeFunction) &&
                Objects.equals(nameFunction, that.nameFunction) &&
                Objects.equals(description, that.description) &&
                Objects.equals(data, that.data) &&
                Objects.equals(minData, that.minData) &&
                Objects.equals(maxData, that.maxData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunction, device, typeFunction, nameFunction, description, data, minData, maxData);
    }

    @ManyToOne
    @JoinColumn(name = "device", referencedColumnName = "id_device", nullable = false,insertable = false, updatable = false)
    public DevicesEntity getDevicesByDevice() {
        return devicesByDevice;
    }

    public void setDevicesByDevice(DevicesEntity devicesByDevice) {
        this.devicesByDevice = devicesByDevice;
    }

    @ManyToOne
    @JoinColumn(name = "type_function", referencedColumnName = "id_type", nullable = false,insertable = false, updatable = false)
    public TypeFunctionEntity getTypeFunctionByTypeFunction() {
        return typeFunctionByTypeFunction;
    }

    public void setTypeFunctionByTypeFunction(TypeFunctionEntity typeFunctionByTypeFunction) {
        this.typeFunctionByTypeFunction = typeFunctionByTypeFunction;
    }

    @OneToMany(mappedBy = "functionDevicesByFunctionDevices")
    public Collection<FunctionsGroupsEntity> getFunctionsGroupsByIdFunction() {
        return functionsGroupsByIdFunction;
    }

    public void setFunctionsGroupsByIdFunction(Collection<FunctionsGroupsEntity> functionsGroupsByIdFunction) {
        this.functionsGroupsByIdFunction = functionsGroupsByIdFunction;
    }

    @OneToMany(mappedBy = "functionDevicesByFunctionDevices")
    public Collection<JournalErrorEntity> getJournalErrorsByIdFunction() {
        return journalErrorsByIdFunction;
    }

    public void setJournalErrorsByIdFunction(Collection<JournalErrorEntity> journalErrorsByIdFunction) {
        this.journalErrorsByIdFunction = journalErrorsByIdFunction;
    }

    @OneToMany(mappedBy = "functionDevicesByFunctionDevices")
    public Collection<JournalEventEntity> getJournalEventsByIdFunction() {
        return journalEventsByIdFunction;
    }

    public void setJournalEventsByIdFunction(Collection<JournalEventEntity> journalEventsByIdFunction) {
        this.journalEventsByIdFunction = journalEventsByIdFunction;
    }
}
