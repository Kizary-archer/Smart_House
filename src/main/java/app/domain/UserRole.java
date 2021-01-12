package app.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@EqualsAndHashCode
public class UserRole implements GrantedAuthority {
    @Id
    @Column(name = "id_role", nullable = false)
    private Integer idRole;
    @Column(name = "name_role")
    private String role;
    @Column(name = "description", length = 200)
    private String description;

    @Override
    public String getAuthority() {
        return getRole();
    }
}
