package com.yeopp.community.config;

import com.yeopp.community.entity.UserEntity;
import lombok.extern.java.Log;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Log
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userIdentification) throws UsernameNotFoundException {
        List<UserEntity> userEntities = em.createQuery("select vo from UserEntity vo where vo.userIdentification = :userIdentification", UserEntity.class)
                .setParameter("userIdentification", userIdentification).getResultList();

        if (userEntities.size() == 0) {
            throw new UsernameNotFoundException("User Not Found");
        }

        UserEntity entity = userEntities.stream().findFirst().get();

        return new User(
                entity.getUserIdentification(),
                entity.getUserPassword(),
                entity.getRoleEntityList().stream().map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getRoleName())).collect(toList())
        );
    }
}
