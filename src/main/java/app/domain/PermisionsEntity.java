package app.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "permisions", schema = "public", catalog = "Smart_house")
public class PermisionsEntity {
    private Long idPermission;
    private String namePermission;
    private Collection<PermissionUserRoleEntity> permissionUserRolesByIdPermission;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission", nullable = false)
    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

    @Basic
    @Column(name = "name_permission", nullable = false, length = -1)
    public String getNamePermission() {
        return namePermission;
    }

    public void setNamePermission(String namePermission) {
        this.namePermission = namePermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisionsEntity that = (PermisionsEntity) o;
        return Objects.equals(idPermission, that.idPermission) &&
                Objects.equals(namePermission, that.namePermission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPermission, namePermission);
    }

    @OneToMany(mappedBy = "permisionsByPermission")
    public Collection<PermissionUserRoleEntity> getPermissionUserRolesByIdPermission() {
        return permissionUserRolesByIdPermission;
    }

    public void setPermissionUserRolesByIdPermission(Collection<PermissionUserRoleEntity> permissionUserRolesByIdPermission) {
        this.permissionUserRolesByIdPermission = permissionUserRolesByIdPermission;
    }
}
