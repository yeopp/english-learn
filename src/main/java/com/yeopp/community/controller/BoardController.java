package com.yeopp.community.controller;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.service.BoardService;
import com.yeopp.community.vo.BoardVo;
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

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value = {"/", "/boards"}, method = RequestMethod.GET)
    public ModelAndView home(@PageableDefault(sort = {"boardId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView model = new ModelAndView("public/index");
        Page<BoardEntity> boardEntity = boardService.listBoard(pageable);

        model.addObject("boardVo", boardEntity);
/*        Boolean test = boardEntity.getContent().get(0).isToday();
        System.out.println(test);*/
        return model;
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public ModelAndView boardAdd(@ModelAttribute("boardVo") BoardVo boardVo) {
        return new ModelAndView("board-add");
    }

    @RequestMapping(value = "/board/addAf", method = RequestMethod.POST)
    public String boardAddAf(BoardVo boardVo) {
        System.out.println(boardVo.toString());
        boardVo.setBoardWriter("teset");
        BoardEntity entity = boardService.addBoard(boardVo);
        return "redirect:/boards/" + entity.getBoardId();
    }

    @RequestMapping(value = "/boards/{boardId}", method = RequestMethod.GET)
    public String boardView(@PathVariable Integer boardId, Model model) {


        BoardEntity boardEntity = boardService.detailBoard(boardId);

        if(boardEntity == null){
            return "redirect:/boards";
        }
        model.addAttribute("boardEntity", boardEntity);

        return "public/board-view";
    }
}
