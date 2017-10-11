package com.kokoharry.website.manager.service;

import com.kokoharry.website.manager.bean.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by luyb on 2017/9/6.
 */
public interface IMenuService {

    List<Menu> getMenusByRoleCode(String roleCode);

    List<Menu> getMenusForPage(int fristNum, int limitNum);

    int getMenusCount();

    Menu addMenu(Menu menu);

    int deleteMenu(long id);

    int editMenu(Menu menu);

    List<Map<String,Object>> getParentMenusForTree(String roleCode);
}
