package com.yeopp.community.service;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.vo.BoardVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;
import java.security.Principal;

public interface BoardService {

    BoardEntity addBoard(BoardVo boardVo, String identification);

    BoardEntity detailBoard(Integer boardId);

    Page<BoardEntity> listBoard(Pageable pageable);

    BoardEntity editBoard(BoardVo boardVo);

    Boolean removeBoard(Integer boardId);

    void boardViewService(Integer boardId, Principal principal, HttpSession session);

    Integer boardRecommendationService(Integer boardId, Integer recommended, Principal principal);
}
