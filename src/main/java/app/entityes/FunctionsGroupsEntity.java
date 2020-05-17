package app.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "functions_groups", schema = "public", catalog = "Smart_house")
public class FunctionsGroupsEntity {
    private Long functionDevices;
    private Long groupFunction;
    private Long id;
    private FunctionDevicesEntity functionDevicesByFunctionDevices;
    private GroupFunctionEntity groupFunctionByGroupFunction;

    @Basic
    @Column(name = "function_devices", nullable = false)
    public Long getFunctionDevices() {
        return functionDevices;
    }

    public void setFunctionDevices(Long functionDevices) {
        this.functionDevices = functionDevices;
    }

    @Basic
    @Column(name = "group_function", nullable = false)
    public Long getGroupFunction() {
        return groupFunction;
    }

    public void setGroupFunction(Long groupFunction) {
        this.groupFunction = groupFunction;
    }

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionsGroupsEntity that = (FunctionsGroupsEntity) o;
        return Objects.equals(functionDevices, that.functionDevices) &&
                Objects.equals(groupFunction, that.groupFunction) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionDevices, groupFunction, id);
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
    @JoinColumn(name = "group_function", referencedColumnName = "id_group", nullable = false)
    public GroupFunctionEntity getGroupFunctionByGroupFunction() {
        return groupFunctionByGroupFunction;
    }

    public void setGroupFunctionByGroupFunction(GroupFunctionEntity groupFunctionByGroupFunction) {
        this.groupFunctionByGroupFunction = groupFunctionByGroupFunction;
    }
}
