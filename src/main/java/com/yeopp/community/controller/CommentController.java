package com.yeopp.community.controller;

import com.yeopp.community.service.CommentService;
import com.yeopp.community.vo.CommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Transactional
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public String addComment(CommentVo commentVo, Principal principal) {
        commentService.addComment(commentVo, principal);
        return "redirect:/boards/" + commentVo.getBoardId();
    }
}
