package com.kokoharry.website.manager.service.impl;

import com.kokoharry.common.util.MessageDigestAlgorithmUtil;
import com.kokoharry.website.manager.bean.User;
import com.kokoharry.website.manager.dao.UserMapper;
import com.kokoharry.website.manager.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean checkUserName(String userName) {
        User user = new User();
        user.setUserName(userName);
        int count = userMapper.selectExits(user);
        if(count > 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User getUserForLogin(String userName, String password) {
        return userMapper.selectUserForLogin(userName, MessageDigestAlgorithmUtil.getMD5Pwd(password));
    }

    @Override
    public List<User> getUsersForPage(int fristNum, int limitNum) {
        return userMapper.getListForPage(null,fristNum,limitNum);
    }

    @Override
    public int getUsersCount() {
        return userMapper.selectTotalCount();
    }

    @Override
    public User addUser(User user) {
        //密码md5赋值
        if(user != null && user.getPassword() != null){
            String pwd = user.getPassword();
            user.setPassword(MessageDigestAlgorithmUtil.getMD5Pwd(pwd));
            //通过网络模式添加
            user.setCreateType(1);
            userMapper.insert(user);
        }
        return user;
    }

    @Override
    public int deleteUser(long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int editUser(User user) {
        user.setUpdateType(1);
        return userMapper.updateByPrimaryKey(user);
    }
}
