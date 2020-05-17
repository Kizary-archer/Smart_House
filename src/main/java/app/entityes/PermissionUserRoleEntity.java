package app.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permission_user_role", schema = "public", catalog = "Smart_house")
public class PermissionUserRoleEntity {
    private Long userRole;
    private Long permission;
    private UserRoleEntity userRoleByUserRole;
    private PermisionsEntity permisionsByPermission;

    @Basic
    @Column(name = "user_role", nullable = false)
    public Long getUserRole() {
        return userRole;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "permission", nullable = false)
    public Long getPermission() {
        return permission;
    }

    public void setPermission(Long permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionUserRoleEntity that = (PermissionUserRoleEntity) o;
        return Objects.equals(userRole, that.userRole) &&
                Objects.equals(permission, that.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRole, permission);
    }

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "id_role", nullable = false)
    public UserRoleEntity getUserRoleByUserRole() {
        return userRoleByUserRole;
    }

    public void setUserRoleByUserRole(UserRoleEntity userRoleByUserRole) {
        this.userRoleByUserRole = userRoleByUserRole;
    }

    @ManyToOne
    @JoinColumn(name = "permission", referencedColumnName = "id_permission", nullable = false)
    public PermisionsEntity getPermisionsByPermission() {
        return permisionsByPermission;
    }

    public void setPermisionsByPermission(PermisionsEntity permisionsByPermission) {
        this.permisionsByPermission = permisionsByPermission;
    }
}
