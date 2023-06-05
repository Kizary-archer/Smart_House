package com.smart_house.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "user_status")
public class UserStatus {
    @Id
    @Column(name = "id_user_status", nullable = false)
    private Integer idUserStatus;
    @Basic
    @Column(name = "status_name", nullable = false, length = 50)
    private String status;
    @Basic
    @Column(name = "description", length = 200)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserStatus that = (UserStatus) o;
        return idUserStatus != null && Objects.equals(idUserStatus, that.idUserStatus);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
