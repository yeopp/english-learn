package com.yeopp.community.service;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.vo.BoardVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    BoardEntity addBoard(BoardVo boardVo);

    BoardEntity detailBoard(Integer boardId);

    Page<BoardEntity> listBoard(Pageable pageable);

    Boolean editBoard(Integer boardId);

    Boolean removeBoard(Integer boardId);
}
