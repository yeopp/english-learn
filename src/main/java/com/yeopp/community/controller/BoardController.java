package com.yeopp.community.controller;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.entity.CommentEntity;
import com.yeopp.community.service.BoardService;
import com.yeopp.community.service.CommentService;
import com.yeopp.community.vo.BoardVo;
import com.yeopp.community.vo.CommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @RequestMapping(value = {"/", "/boards"}, method = RequestMethod.GET)
    public ModelAndView home(@PageableDefault(sort = {"boardId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView model = new ModelAndView("public/index");
        Page<BoardEntity> boardEntity = boardService.listBoard(pageable);
        model.addObject("boardVo", boardEntity);
        return model;
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public ModelAndView boardAdd(@ModelAttribute("boardVo") BoardVo boardVo) {
        return new ModelAndView("board-add");
    }

    @RequestMapping(value = "/board/addAf", method = RequestMethod.POST)
    public String boardAddAf(BoardVo boardVo, Principal principal) {
        BoardEntity entity = boardService.addBoard(boardVo, principal.getName());
        return "redirect:/boards/" + entity.getBoardId();
    }

    @RequestMapping(value = "/boards/{boardId}", method = RequestMethod.GET)
    public String boardView(@PathVariable Integer boardId,
                            @ModelAttribute("commentVo") CommentVo commentVo,
                            @PageableDefault(sort = "commentId", direction = Sort.Direction.DESC) Pageable pageable,
                            Model model,
                            HttpSession session,
                            Principal principal) {

        BoardEntity boardEntity = boardService.detailBoard(boardId);
        boardService.boardViewService(boardId, principal, session);

        if (boardEntity == null) {
            return "redirect:/boards";
        }

        Page<CommentEntity> commentList = commentService.getComment(boardId, pageable);

        model.addAttribute("boardEntity", boardEntity);
        model.addAttribute("principal", principal != null ? principal.getName() : null);
        model.addAttribute("commentList", commentList);
        return "public/board-view";
    }
}
