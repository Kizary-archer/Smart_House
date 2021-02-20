package com.smart_house.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
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
}
