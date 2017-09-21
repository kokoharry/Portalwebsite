package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.Role;
import org.springframework.stereotype.Repository;

@Repository("roleMapper")
public interface RoleMapper extends BaseMapper<Role> {

}