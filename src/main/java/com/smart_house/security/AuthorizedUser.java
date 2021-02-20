package com.smart_house.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@EqualsAndHashCode(callSuper = true)
public class AuthorizedUser extends User {

    private final Integer id;
    public AuthorizedUser(com.smart_house.entities.User user) {
        this(user.getId(), user.getLogin(), user.getPassword(), user.grantedAuthorities());
    }

    public AuthorizedUser(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }
}
