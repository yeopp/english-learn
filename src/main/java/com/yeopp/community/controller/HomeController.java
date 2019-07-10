package com.yeopp.community.controller;

import com.yeopp.community.entity.UserEntity;
import com.yeopp.community.service.UserService;
import com.yeopp.community.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @RequestMapping(value = "/public/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        UserEntity entity = new UserEntity();
        model.addAttribute(entity);
        return "public/login";
    }

    @RequestMapping(value = "/public/join", method = RequestMethod.GET)
    public String joinPage(Model model) {
        UserVo userVo = new UserVo();
        model.addAttribute(userVo);
        return "public/join";
    }

    @RequestMapping(value = "/public/joinAf", method = RequestMethod.POST)
    public String joinAfPage(@ModelAttribute("userVo") UserVo vo) {
        System.out.println(vo.toString());
        userService.addUser(vo);
        return "redirect:/boards";
    }

}
