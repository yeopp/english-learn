package com.yeopp.community.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_role")
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 10, nullable = false)
    private String roleName;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;

    @ManyToMany(mappedBy = "roleEntityList")
    private List<UserEntity> userEntityList;
}
