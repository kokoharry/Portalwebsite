package com.kokoharry.website.manager.service.impl;

import com.kokoharry.website.manager.bean.Menu;
import com.kokoharry.website.manager.bean.Role;
import com.kokoharry.website.manager.dao.MenuMapper;
import com.kokoharry.website.manager.dao.RoleMapper;
import com.kokoharry.website.manager.service.IMenuService;
import com.kokoharry.website.manager.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByRoleCode(String roleCode) {

        List<Menu> result = new ArrayList<>();
        List<Menu> list = menuMapper.getMenusByRoleCode(roleCode);
        for(Menu menu : list){
            if(menu.getMenuParentCode()==null||"".equals(menu.getMenuParentCode())){
                //没有父节点code为主节点
                result.add(menu);
            }
            menu.setMenus(getMenusFromListByParentCode(list,menu.getMenuCode()));
        }
        return result;
    }

    private List<Menu> getMenusFromListByParentCode(List<Menu> list, String code){
        List<Menu> result = new ArrayList<>();
        for(Menu menu : list){
            if(menu.getMenuParentCode()!=null && menu.getMenuParentCode().equals(code)){
                result.add(menu);
            }
        }
        return result;
    }
}
