package com.kokoharry.website.manager.service;

import com.kokoharry.website.manager.bean.Menu;

import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
public interface IMenuService {

    List<Menu> getMenusByRoleCode(String roleCode);
}
