package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.service.IRoleService;
import com.kokoharry.website.manager.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by luyb on 2017/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:spring-mybatis.xml" })
public class RoleServiceImplTest {

    @Resource
    public IRoleService roleService;

    @Test
    public void testGetRoleById(){
        roleService.getRoleById(1);
    }

}