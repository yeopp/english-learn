package com.yeopp.community.repository;

import com.yeopp.community.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationEntity, Integer> {
    Integer countByUserIdAndBoardEntityBoardId(String userId, Integer boardId);

    Integer countByBoardEntityBoardId(Integer boardId);
}