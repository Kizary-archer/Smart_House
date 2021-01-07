package app.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "groups_controllers", schema = "public", catalog = "Smart_house")
public class GroupsControllersEntity {
    private Long group;
    private Long controller;
    private Long id;
    private GroupControllerEntity groupControllerByGroup;
    private ControllersEntity controllersByController;

    @Basic
    @Column(name = "group", nullable = false)
    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    @Basic
    @Column(name = "controller", nullable = false)
    public Long getController() {
        return controller;
    }

    public void setController(Long controller) {
        this.controller = controller;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        GroupsControllersEntity that = (GroupsControllersEntity) o;
        return Objects.equals(group, that.group) &&
                Objects.equals(controller, that.controller) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, controller, id);
    }

    @ManyToOne
    @JoinColumn(name = "group", referencedColumnName = "id_group", nullable = false,insertable = false, updatable = false)
    public GroupControllerEntity getGroupControllerByGroup() {
        return groupControllerByGroup;
    }

    public void setGroupControllerByGroup(GroupControllerEntity groupControllerByGroup) {
        this.groupControllerByGroup = groupControllerByGroup;
    }

    @ManyToOne
    @JoinColumn(name = "controller", referencedColumnName = "id_controller", nullable = false,insertable = false, updatable = false)
    public ControllersEntity getControllersByController() {
        return controllersByController;
    }

    public void setControllersByController(ControllersEntity controllersByController) {
        this.controllersByController = controllersByController;
    }
}
