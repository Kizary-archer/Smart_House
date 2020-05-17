package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "group_function", schema = "public", catalog = "Smart_house")
public class GroupFunctionEntity {
    private Long idGroup;
    private String nameGroup;
    private String decription;
    private Integer user;
    private Collection<FunctionsGroupsEntity> functionsGroupsByIdGroup;
    private UsersEntity usersByUser;

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

    @Basic
    @Column(name = "user", nullable = false)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupFunctionEntity that = (GroupFunctionEntity) o;
        return Objects.equals(idGroup, that.idGroup) &&
                Objects.equals(nameGroup, that.nameGroup) &&
                Objects.equals(decription, that.decription) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGroup, nameGroup, decription, user);
    }

    @OneToMany(mappedBy = "groupFunctionByGroupFunction")
    public Collection<FunctionsGroupsEntity> getFunctionsGroupsByIdGroup() {
        return functionsGroupsByIdGroup;
    }

    public void setFunctionsGroupsByIdGroup(Collection<FunctionsGroupsEntity> functionsGroupsByIdGroup) {
        this.functionsGroupsByIdGroup = functionsGroupsByIdGroup;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id_user", nullable = false)
    public UsersEntity getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(UsersEntity usersByUser) {
        this.usersByUser = usersByUser;
    }
}
