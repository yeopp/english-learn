package com.yeopp.community.vo;

import com.yeopp.community.type.YesNoType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserVo implements Serializable {

    private Integer userId;

    private String userIdentification;

    private String userPassword;

    private String userName;

    private String userEmail;

    private String userPhoneNumber;

    private YesNoType deleteAt;

    private Date lastLoginDt;

    private Date createDt;

    private Date updateDt;
}
