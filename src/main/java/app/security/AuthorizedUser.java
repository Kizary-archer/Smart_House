package app.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

@Getter
@EqualsAndHashCode(callSuper = true)
public class AuthorizedUser extends User {

    private final Integer id;

    public AuthorizedUser(app.entities.User user) {
        this(user.getIdUser(), user.getLogin(), user.getPassword(), Collections.singletonList(user.getRole()));
    }

    public AuthorizedUser(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }
}
