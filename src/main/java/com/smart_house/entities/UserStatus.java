package com.smart_house.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode
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

}
