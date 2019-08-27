package com.yeopp.community.repository;

import com.yeopp.community.entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    Page<CommentEntity> findByBoardEntityBoardId(Integer boardId, Pageable pageable);
}
