package com.yeopp.community.repository;

import com.yeopp.community.entity.ViewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewsRepository extends JpaRepository<ViewsEntity, Integer> {
    ViewsEntity findByUserIdAndBoardEntityBoardId(String userId, Integer boardId);
}
