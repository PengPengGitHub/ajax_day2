package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

import java.sql.SQLException;

public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
/*
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

        connection.setAutoCommit(false);

        connection.commit();

        System.out.println(connection);*/
        UserDAO userDAO = MybatisUtils.getSqlSession().getMapper(UserDAO.class);
        userDAO.save(new User("21","小黑"));
        MybatisUtils.commit();
    }
}
