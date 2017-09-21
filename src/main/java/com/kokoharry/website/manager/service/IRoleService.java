package com.kokoharry.website.manager.service;

import com.kokoharry.website.manager.bean.Role;

/**
 * Created by luyb on 2017/9/6.
 */
public interface IRoleService {

    Role getRoleById(long id);

    Role getRoleByCode(String code);

}
