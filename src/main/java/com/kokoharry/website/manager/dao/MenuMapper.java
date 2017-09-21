package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.Menu;
import com.kokoharry.website.manager.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuMapper")
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByRoleCode(String roleCode);

}