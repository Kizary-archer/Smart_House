package com.smart_house.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "registration_date")
    private Timestamp registrationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private UserStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private UserRole role;

    public Collection<? extends GrantedAuthority> grantedAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(role.getPermissions());
        grantedAuthorities.add(role);
        return grantedAuthorities;
    }
}
