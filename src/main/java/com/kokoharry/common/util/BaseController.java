package com.kokoharry.common.util;

import com.kokoharry.website.manager.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by luyb on 2017/9/27.
 */
public class BaseController {

    @ExceptionHandler({AuthorizationException.class})
    public ModelAndView processAuthorizationException(AuthorizationException ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ErrorMsg", ex.getMessage());
        mv.addObject("ErrorTitle", "用户权限不足");
        // 为了区分，跳转掉另一个视图
        mv.setViewName("error/error");
        return mv;
    }

    public User getCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);
        if(user == null){
            throw new AuthorizationException("用户还没有登录");
        }
        return user;
    }

}
