package com.yeopp.community.controller;

import com.yeopp.community.service.BoardService;
import com.yeopp.community.service.UserService;
import com.yeopp.community.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AjaxController {

    private final UserService userService;
    private final BoardService boardService;

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/boards/editRecommended", method = RequestMethod.POST)
    public ResponseEntity<Integer> editRecommended(@RequestBody BoardVo vo, Principal principal) {
        System.out.println(vo.toString());
        return ResponseEntity.ok(boardService.boardRecommendationService(vo.getBoardId(), vo.getRecommended(), principal));
    }

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/user/idValidationCheck", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkUserIdentification(@RequestBody String userIdentification){
        return ResponseEntity.ok(userService.userIdentificationCheck(userIdentification.trim()));
    }
}
