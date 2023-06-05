package com.smart_house.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@Accessors(chain = true)
public class UserRole implements GrantedAuthority {
    @Id
    @Column(name = "id_role", nullable = false)
    private Integer idRole;
    @Column(name = "name_role")
    private String role;
    @Column(name = "description", length = 200)
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "permission_user_role",
            joinColumns = {@JoinColumn(name = "user_role")},
            inverseJoinColumns = {@JoinColumn(name = "permission")}
    )
    private Set<Permission> permissions;

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRole userRole = (UserRole) o;
        return idRole != null && Objects.equals(idRole, userRole.idRole);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
