package com.yeopp.community.service.impl;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.repository.BoardRepository;
import com.yeopp.community.service.BoardService;
import com.yeopp.community.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardEntity addBoard(BoardVo boardVo) {
        BoardEntity boardEntity = new BoardEntity(boardVo);
        boardRepository.save(boardEntity);
        return boardEntity;
    }

    @Override
    public Page<BoardEntity> listBoard(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public BoardEntity detailBoard(Integer boardId) {
        return boardRepository.getOne(boardId);
    }

    @Override
    public Boolean editBoard(Integer boardId) {
        return null;
    }

    @Override
    public Boolean removeBoard(Integer boardId) {
        return null;
    }
}
