package app.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "controllers", schema = "public", catalog = "Smart_house")
public class ControllersEntity {
    private Long idController;
    private Long user;
    private Long model;
    private Timestamp startDate;
    private Long workStatus;
    private String nameController;
    private UsersEntity usersByUser;
    private ControllerModelEntity controllerModelByModel;
    private WorkStatusEntity workStatusByWorkStatus;
    private Collection<DevicesEntity> devicesByIdController;
    private Collection<GroupsControllersEntity> groupsControllersByIdController;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_controller", nullable = false)
    public Long getIdController() {
        return idController;
    }

    public void setIdController(Long idController) {
        this.idController = idController;
    }

    @Basic
    @Column(name = "user", nullable = false)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Basic
    @Column(name = "model", nullable = true)
    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
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
    @Column(name = "name_controller", nullable = false, length = 50)
    public String getNameController() {
        return nameController;
    }

    public void setNameController(String nameController) {
        this.nameController = nameController;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllersEntity that = (ControllersEntity) o;
        return Objects.equals(idController, that.idController) &&
                Objects.equals(user, that.user) &&
                Objects.equals(model, that.model) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(workStatus, that.workStatus) &&
                Objects.equals(nameController, that.nameController);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idController, user, model, startDate, workStatus, nameController);
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id_user", nullable = false,insertable = false, updatable = false)
    public UsersEntity getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(UsersEntity usersByUser) {
        this.usersByUser = usersByUser;
    }

    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "id_model",insertable = false, updatable = false)
    public ControllerModelEntity getControllerModelByModel() {
        return controllerModelByModel;
    }

    public void setControllerModelByModel(ControllerModelEntity controllerModelByModel) {
        this.controllerModelByModel = controllerModelByModel;
    }

    @ManyToOne
    @JoinColumn(name = "work_status", referencedColumnName = "id_status", nullable = false,insertable = false, updatable = false)
    public WorkStatusEntity getWorkStatusByWorkStatus() {
        return workStatusByWorkStatus;
    }

    public void setWorkStatusByWorkStatus(WorkStatusEntity workStatusByWorkStatus) {
        this.workStatusByWorkStatus = workStatusByWorkStatus;
    }

    @OneToMany(mappedBy = "controllersByController")
    public Collection<DevicesEntity> getDevicesByIdController() {
        return devicesByIdController;
    }

    public void setDevicesByIdController(Collection<DevicesEntity> devicesByIdController) {
        this.devicesByIdController = devicesByIdController;
    }

    @OneToMany(mappedBy = "controllersByController")
    public Collection<GroupsControllersEntity> getGroupsControllersByIdController() {
        return groupsControllersByIdController;
    }

    public void setGroupsControllersByIdController(Collection<GroupsControllersEntity> groupsControllersByIdController) {
        this.groupsControllersByIdController = groupsControllersByIdController;
    }
}
