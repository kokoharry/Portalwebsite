package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleMapper")
public interface RoleMapper extends BaseMapper<Role> {

    Role getRolePermissions(@Param("roleCode")String roleCode);

    List<Role> getRolesByMenuCodeForRelation(String menuCode);

    List<Role> getOtherRolesByMenuCodeForRelation(String menuCode);

}