package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.bean.Role;
import com.kokoharry.website.manager.dao.RoleMapper;
import com.kokoharry.website.manager.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Role getPermissionsByRoleCode(String roleCode) {
        return roleMapper.getRolePermissions(roleCode);
    }

    @Override
    public List<Role> getRolesForPage(int fristNum, int limitNum) {
        return roleMapper.getListForPage(null,fristNum,limitNum);
    }

    @Override
    public int getRolesCount() {
        return roleMapper.selectTotalCount();
    }

    @Override
    public Role addRole(Role role) {
            //通过网络模式添加
        role.setCreateType(1);
        roleMapper.insert(role);
        return role;
    }

    @Override
    public int deleteRole(long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int editRole(Role role) {
        role.setUpdateType(1);
        return roleMapper.updateByPrimaryKey(role);
    }
}
