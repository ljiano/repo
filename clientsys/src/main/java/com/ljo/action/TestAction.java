package com.ljo.action;

import com.ljo.dto.User;
import com.ljo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by jb.liang on 2017/4/7.
 */
@Controller
@RequestMapping("/test")
public class TestAction {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("message", "test");
        User user = userService.getuserById(new Integer(1));
        if(user != null){
            model.addAttribute("name", user.getUsername());
        }
        return "user/usertest";
    }
}
