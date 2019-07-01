package com.yeopp.community.controller;

import com.yeopp.community.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @RequestMapping(value = "/board/add", method = RequestMethod.GET)
    public ModelAndView boardAdd(@ModelAttribute("boardVo") BoardVo boardVo) {
        return new ModelAndView("board-add");
    }

    @RequestMapping(value = "/board/addAf", method = RequestMethod.POST)
    public String boardAddAf(BoardVo boardVo) {
        System.out.println(boardVo.toString());
        return "index";
    }
}
