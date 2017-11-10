package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.Role;
import com.kokoharry.website.manager.bean.RoleMenuRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleMenuRelationMapper")
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation> {
    int deleteByMenuCode(String menuCode);
}