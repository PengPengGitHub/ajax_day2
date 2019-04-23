package com.baizhi.dao;

import com.baizhi.entity.Message;

import java.util.List;

public interface MessageDAO {


    List<Message> findAll();


    void save(Message message);


}
