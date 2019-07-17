package com.yeopp.community.controller;

import com.yeopp.community.entity.BoardEntity;
import com.yeopp.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class AjaxController {

    private final BoardService boardService;

    @Transactional
    @RequestMapping(value = "/editRecommended", method = RequestMethod.POST)
    public BoardEntity editRecommended(@RequestBody boolean flag) {

        /*BoardEntity entity = boardService.detailBoard(Integer.valueOf(vo.getBoardId()));*/

        return null;
    }
}
