package com.yeopp.community.entity;

import com.yeopp.community.type.YesNoType;
import com.yeopp.community.vo.UserVo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
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

    @CreationTimestamp
    private Date createDt;

    @UpdateTimestamp
    private Date updateDt;

    @ManyToMany
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "fk_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_role_id")
    )
    private List<RoleEntity> roleEntityList;

    public UserEntity(UserVo vo) {
        this.userIdentification = vo.getUserIdentification();
        this.userName = vo.getUserName();
        this.userEmail = vo.getUserEmail();
        this.userPhoneNumber = vo.getUserPhoneNumber();
    }
}
