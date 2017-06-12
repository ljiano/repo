package com.ljo.action;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.User;
import com.ljo.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/7.
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    public static Log LOGGER = LogFactory.getLog(UserAction.class);

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public String findAllUser(Model model){
        List<User> list = userService.findAllUsers();
        if(!CollectionUtils.isEmpty(list)){
            model.addAttribute("users", list);
        }
        return "user/listuser";
    }

    @ResponseBody
    @RequestMapping("/saveuser")
    public String saveUser(User user) {
        try{
            userService.saveUser(user);
            return "ok";
        } catch (Exception e) {
            LOGGER.error("添加用户失败！", e);
            return "err";
        }
    }

    @RequestMapping("/findusers")
    public String findUsers(Model model, @Param(value = "pageNo") Integer pageNo,
                            @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "");
        param.put("password", "");
        PageInfo<User> pageInfo = userService.findUsersByParam(param, pageNo, pageSize);
        if(pageInfo != null){
            //List<User> list = pageInfo.getList();
            model.addAttribute("page", pageInfo);
            model.addAttribute("pageNo", pageNo);
            model.addAttribute("pageSize", pageSize);
        }

        return "user/listuser";
    }

    @ResponseBody
    @RequestMapping("/finduserstr")
    public String findUserOfJSON(@Param("username") String username, @Param(value = "pageNo") Integer pageNo,
                                 @Param(value = "pageSize")Integer pageSize){
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", "%" + username + "%");
        PageInfo<User> pageInfo = userService.findUsersByParam(param, pageNo, pageSize);
        if(pageInfo != null){

        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/findusercompanys")
    public String findUserCompanys(@Param("uid") Integer uid, @Param(value = "pageNo") Integer pageNo,
                                 @Param(value = "pageSize")Integer pageSize) {
        if(pageNo == null) pageNo = 1;
        if(pageSize == null) pageSize = 10;
        PageInfo<Map<String, Object>> pageInfo = this.userService.findUserCompanys(uid, pageNo, pageSize);
        if(pageInfo != null){
            return JSONObject.fromObject(pageInfo).toString();
        }
        return "";
    }
}
