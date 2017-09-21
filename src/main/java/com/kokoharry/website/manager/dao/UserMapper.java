package com.kokoharry.website.manager.dao;

import com.kokoharry.common.util.BaseMapper;
import com.kokoharry.website.manager.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper extends BaseMapper<User> {

    int selectExits(User user);

    User selectUserForLogin(@Param("userName") String userName, @Param("password") String password);
}