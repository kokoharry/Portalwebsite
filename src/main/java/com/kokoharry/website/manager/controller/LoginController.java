package com.kokoharry.website.manager.controller;

import com.kokoharry.website.manager.bean.Menu;
import com.kokoharry.website.manager.bean.Role;
import com.kokoharry.website.manager.bean.User;
import com.kokoharry.website.manager.service.IMenuService;
import com.kokoharry.website.manager.service.IRoleService;
import com.kokoharry.website.manager.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {
    /**
     * 日志类
     */
    public static Logger logger = LogManager.getLogger(LoginController.class);

    @Resource
    private IUserService userService;

    @Resource
    public IRoleService roleService;

    @Resource
    public IMenuService menuService;

    /**
     * 登录判断 成功跳转后台，失败返回登录页面
     * @param userName
     * @param password
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "login",method= RequestMethod.POST)
    public ModelAndView login(String userName, String password,ModelAndView modelAndView) {
        logger.debug("/login/login request Pram =  {userName:" + userName + ";password:" + password +"}");
        User user = null;
        if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)){
             user =  userService.getUserForLogin(userName,password);
        }
        logger.debug("/login/login response result =  {" + user + "}");
        if(user == null){
            //登录失败返回登录页面提示错误信息
            modelAndView.setViewName("login/login");
            modelAndView.addObject("resultMsg","用户名或者密码错误");
        }else{
            //登陆成功，需要获取用户权限信息构建frame 跳转页面
            Role role = roleService.getRoleByCode(user.getRoleCode());
            List<Menu> list = menuService.getMenusByRoleCode(user.getRoleCode());
            modelAndView.setViewName("frame/index");
            modelAndView.addObject("user",user);
            modelAndView.addObject("role",role);
            modelAndView.addObject("menus",list);
        }
        return modelAndView;
    }

    /**
     * login 页面跳转
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "loginPage")
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    /**
     * login 主页面跳转
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "mainPage")
    public ModelAndView mainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("frame/main");
        return modelAndView;
    }

    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkUserName",method= RequestMethod.POST)
    public String checkUserName(String userName) {
        logger.debug("/login/checkUserName request Pram =  {userName:"+userName+"}");
        Boolean flag =  userService.checkUserName(userName);
        logger.debug("/login/checkUserName response result =  {"+flag.toString()+"}");
        return flag.toString();
    }
}