package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Message;
import com.baizhi.service.MessageService;
import com.baizhi.service.MessageServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageAction {


    private MessageService messageService = new MessageServiceImpl();

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String save(){
        messageService.save(message);
        return Action.NONE;
    }

    public String findAll() throws IOException {
        List<Message> messages = messageService.findAll();
        String json = JSONObject.toJSONStringWithDateFormat(messages, "yyyy-MM-dd");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return Action.NONE;
    }
}
