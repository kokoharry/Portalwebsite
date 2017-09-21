package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.bean.Menu;
import com.kokoharry.website.manager.service.IMenuService;
import com.kokoharry.website.manager.service.IRoleService;
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
@ContextConfiguration(locations={ "classpath:spring-mybatis.xml" })
public class MenuServiceImplTest {

    @Resource
    public IRoleService roleService;

    @Resource
    public IMenuService menuService;

    @Test
    public void getMenusByRoleCode() throws Exception {
        List<Menu> list = menuService.getMenusByRoleCode("master");
        System.out.println(list);
    }

}