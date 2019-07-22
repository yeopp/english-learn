package com.yeopp.community.service;

import com.yeopp.community.entity.UserEntity;
import com.yeopp.community.vo.UserVo;

public interface UserService {

    UserEntity addUser(UserVo userVo);

    Boolean userIdentificationCheck(String userId);
}
