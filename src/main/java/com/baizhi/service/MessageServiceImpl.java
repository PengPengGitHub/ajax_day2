package com.baizhi.service;

import com.baizhi.dao.MessageDAO;
import com.baizhi.entity.Message;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class  MessageServiceImpl implements MessageService {


    @Override
    public void save(Message message) {
        MessageDAO messageDAO = MybatisUtils.getSqlSession().getMapper(MessageDAO.class);
        try {
            message.setId(UUID.randomUUID().toString());
            message.setCreateDate(new Date());
            User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
            message.setUser(user);
            message.setCounts(1);
            messageDAO.save(message);
            MybatisUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtils.rollback();
        }

    }

    @Override
    public List<Message> findAll() {
        MessageDAO messageDAO = MybatisUtils.getSqlSession().getMapper(MessageDAO.class);
        List<Message> messages = messageDAO.findAll();
        MybatisUtils.close();
        return messages;
    }
}
