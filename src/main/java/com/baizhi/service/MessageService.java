package com.baizhi.service;

import com.baizhi.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    void save(Message message);
}
