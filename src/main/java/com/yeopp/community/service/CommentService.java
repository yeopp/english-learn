package com.yeopp.community.service;

import com.yeopp.community.entity.CommentEntity;
import com.yeopp.community.vo.CommentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

public interface CommentService {
    void addComment(CommentVo vo, Principal principal);

    Page<CommentEntity> getComment(Integer boardId, Pageable pageable);
}
