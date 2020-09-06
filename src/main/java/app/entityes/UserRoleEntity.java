package app.entityes;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "public", catalog = "Smart_house")
public class UserRoleEntity {
    @Expose()
    private Long idRole;
    @Expose()
    private String nameRole;
    @Expose()
    private String description;
    @Expose(serialize = false, deserialize = false)
    private Collection<PermissionUserRoleEntity> permissionUserRolesByIdRole;
    @Expose(serialize = false, deserialize = false)
    private Collection<UsersEntity> usersByIdRole;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name_role", nullable = false, length = 50)
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
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
        UserRoleEntity that = (UserRoleEntity) o;
        return Objects.equals(idRole, that.idRole) &&
                Objects.equals(nameRole, that.nameRole) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nameRole, description);
    }

    @OneToMany(mappedBy = "userRoleByUserRole")
    public Collection<PermissionUserRoleEntity> getPermissionUserRolesByIdRole() {
        return permissionUserRolesByIdRole;
    }

    public void setPermissionUserRolesByIdRole(Collection<PermissionUserRoleEntity> permissionUserRolesByIdRole) {
        this.permissionUserRolesByIdRole = permissionUserRolesByIdRole;
    }

    @OneToMany(mappedBy = "userRoleByRole")
    public Collection<UsersEntity> getUsersByIdRole() {
        return usersByIdRole;
    }

    public void setUsersByIdRole(Collection<UsersEntity> usersByIdRole) {
        this.usersByIdRole = usersByIdRole;
    }
}
