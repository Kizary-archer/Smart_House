package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "group_controller", schema = "public", catalog = "Smart_house")
public class GroupControllerEntity {
    private Long idGroup;
    private String nameGroup;
    private String decription;
    private Collection<GroupsControllersEntity> groupsControllersByIdGroup;

    @Id
    @Column(name = "id_group", nullable = false)
    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    @Basic
    @Column(name = "name_group", nullable = false, length = 50)
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Basic
    @Column(name = "decription", nullable = true, length = 200)
    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupControllerEntity that = (GroupControllerEntity) o;
        return Objects.equals(idGroup, that.idGroup) &&
                Objects.equals(nameGroup, that.nameGroup) &&
                Objects.equals(decription, that.decription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, nameGroup, decription);
    }

    @OneToMany(mappedBy = "groupControllerByGroup")
    public Collection<GroupsControllersEntity> getGroupsControllersByIdGroup() {
        return groupsControllersByIdGroup;
    }

    public void setGroupsControllersByIdGroup(Collection<GroupsControllersEntity> groupsControllersByIdGroup) {
        this.groupsControllersByIdGroup = groupsControllersByIdGroup;
    }
}
