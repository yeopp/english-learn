package com.yeopp.community.entity;

import com.yeopp.community.type.YesNoType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer userId;

    @Column(nullable = false)
    private String userIdentification;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    private String userEmail;

    @Column(nullable = false)
    private String userPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('Y', 'N')")
    private YesNoType deleteAt;

    private Date lastLoginDt;

    private Date createDt;

    private Date updateDt;

    @ManyToMany
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "fk_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_role_id")
    )
    private List<RoleEntity> roleEntityList;
}
