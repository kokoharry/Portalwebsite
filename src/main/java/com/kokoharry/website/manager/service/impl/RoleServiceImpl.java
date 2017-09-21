package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.bean.Role;
import com.kokoharry.website.manager.dao.RoleMapper;
import com.kokoharry.website.manager.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by luyb on 2017/9/6.
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Role getRoleByCode(String code) {
        return roleMapper.selectOneByCode(code);
    }
}
