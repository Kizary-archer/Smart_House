package com.smart_house.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "permisions")
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class Permission implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission")
    Integer id;
    @Column(name = "name_permission")
    String permission;

    @Override
    public String getAuthority() {
        return permission;
    }
}
