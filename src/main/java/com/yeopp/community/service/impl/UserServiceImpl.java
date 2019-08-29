package com.yeopp.community.service.impl;

import com.yeopp.community.entity.RoleEntity;
import com.yeopp.community.entity.UserEntity;
import com.yeopp.community.repository.RoleRepository;
import com.yeopp.community.repository.UserRepository;
import com.yeopp.community.service.UserService;
import com.yeopp.community.type.YesNoType;
import com.yeopp.community.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserEntity addUser(UserVo userVo) {
        try {
            //TODO... user check validation check 미구현

            List<RoleEntity> role = new ArrayList<>();
            UserEntity userEntity = new UserEntity(userVo);

            RoleEntity roleEntity = roleRepository.findByRoleName("USER");
            role.add(roleEntity);

            userEntity.setUserPassword(passwordEncoder.encode(userVo.getUserPassword()));
            userEntity.setDeleteAt(YesNoType.N);
            userEntity.setRoleEntityList(role);

            return userRepository.save(userEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Boolean userIdentificationCheck(String userId) {

        boolean flag = false;

        UserEntity userEntity = userRepository.findByUserIdentification(userId.trim());
        if (userEntity == null) {
            flag = true;
        }

        return flag;
    }


}
