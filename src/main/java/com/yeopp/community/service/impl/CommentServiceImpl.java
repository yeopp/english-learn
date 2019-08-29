package com.yeopp.community.service.impl;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.entity.CommentEntity;
import com.yeopp.community.repository.BoardRepository;
import com.yeopp.community.repository.CommentRepository;
import com.yeopp.community.service.CommentService;
import com.yeopp.community.vo.CommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public void addComment(CommentVo vo, Principal principal) {
        try {
            CommentEntity commentEntity = new CommentEntity();
            BoardEntity boardEntity = boardRepository.findByBoardId(vo.getBoardId());

            commentEntity.setBoardEntity(boardEntity);
            commentEntity.setCommentContent(vo.getComment());
            commentEntity.setCommentWriter(principal.getName());
            commentRepository.save(commentEntity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CommentEntity> getComment(Integer boardId, Pageable pageable) {
        return commentRepository.findByBoardEntityBoardId(boardId, pageable);
    }
}
