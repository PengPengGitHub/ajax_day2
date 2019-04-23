package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class UserServiceImpl implements  UserService {
    @Override
    public User login(User user) {
        UserDAO userDAO = MybatisUtils.getSqlSession().getMapper(UserDAO.class);
        User userDB = userDAO.findByUserName(user.getName());
        if(userDB!=null){
            return userDB;
        }
        throw new RuntimeException("用户名不存在~~");
    }
}
