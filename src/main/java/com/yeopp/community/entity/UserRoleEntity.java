package com.yeopp.community.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tbl_user_role")
public class UserRoleEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "fk_user_id")
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity userEntity;

    @JoinColumn(name = "fk_role_id")
    @ManyToOne(targetEntity = RoleEntity.class)
    private RoleEntity roleEntity;
}
