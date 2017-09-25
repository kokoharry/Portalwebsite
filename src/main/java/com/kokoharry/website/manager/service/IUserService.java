package com.kokoharry.website.manager.service;

import com.kokoharry.website.manager.bean.User;

import java.util.List;

/**
 * Created by luyb on 2017/9/6.
 */
public interface IUserService {

    boolean checkUserName(String userName);

    User getUserForLogin(String userName , String password);

    List<User> getUsersForPage(int fristNum, int limitNum);

    int getUsersCount();

    User addUser(User user);
}
