package com.kokoharry.website.manager.controller;

import com.kokoharry.website.manager.bean.User;
import com.kokoharry.website.manager.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by luyb on 2017/9/6.
 */
@Controller
@RequestMapping(value="/system")
public class SystemController {
    /**
     * 日志类
     */
    public static Logger logger = LogManager.getLogger(SystemController.class);

    @Resource
    private IUserService userService;

    /**
     * 用户列表页面跳转
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView modelAndView) {
        logger.debug("/manager/index action request");
        modelAndView.setViewName("manager/table");
        return modelAndView;
    }

    /**
     * 用户列表数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "users",method= RequestMethod.POST)
    public Map<String,Object> getUsers(int limit, int start) {
        logger.debug("/system/users action request param:{"+ limit+ ";"+start+"}");
        Map<String,Object> map = new HashMap<>();
        List<User> list = userService.getUsersForPage(start,limit);
        System.out.println(list.size());
        map.put("data",list);
        map.put("total",userService.getUsersCount());
        logger.debug("/system/users response result =  {" + map + "}");
        return map;
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userAdd",method= RequestMethod.POST)
    public long addUsers(User user) {
        //TODO: createUser;
        logger.debug("/system/userAdd action request param:{"+ user+"}");
        user.setCreateUser(0);
        user = userService.addUser(user);
        logger.debug("/system/userAdd action response result:{"+ user+"}");
        if(user != null && user.getId() > 0){
            return user.getId();
        }
        return -1;
    }

}