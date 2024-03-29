package com.yeopp.community.repository;

import com.yeopp.community.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    Page<BoardEntity> findAll(Pageable pageable);

    BoardEntity findByBoardId(Integer boardId);
}
