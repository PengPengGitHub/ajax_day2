package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserAction {

    private UserService userService = new UserServiceImpl();
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //登录方法
    public String login() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User userDB = userService.login(user);
            ServletActionContext.getRequest().getSession().setAttribute("user",userDB);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        String json = JSONObject.toJSONString(map);
        writer.print(json);
        return Action.NONE;
    }
}
