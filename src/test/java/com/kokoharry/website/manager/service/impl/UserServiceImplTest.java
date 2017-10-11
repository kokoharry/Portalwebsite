package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.bean.User;
import com.kokoharry.website.manager.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luyb on 2017/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml" })
public class UserServiceImplTest {

    @Resource
    public IUserService userService;

    @Test
    public void checkUserName() throws Exception {
        userService.checkUserName("123");
    }

    @Test
    public void getUserForLogin() throws Exception {
        User user = userService.getUserForLogin("kokoharry","423111lyb");
    }

    @Test
    public void getUsersForPage() throws Exception {
        List<User> list = userService.getUsersForPage(10,10);
        System.out.println(list.get(0));
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserName("test1");
        user.setRealName("测试后");
        user.setTelphone("1111111111");
        user.setPassword("123456");
        user.setCreateType(1);
        user.setCreateUser(0);
        userService.addUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void editUser() throws Exception {
        User user = new User();
        user.setId(100);
        user.setUserName("test1111");
        user.setRealName("测试后111");
        user.setTelphone("1111111111222");
        user.setUpdateUser(0);
        int res = userService.editUser(user);
        System.out.println(res);
    }

}