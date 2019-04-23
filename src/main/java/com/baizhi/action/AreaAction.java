package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Area;
import com.baizhi.service.AreaService;
import com.baizhi.service.AreaServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AreaAction {

    private AreaService areaService = new AreaServiceImpl();
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String findByCityCode() throws IOException {
        List<Area> areas = areaService.findByCityCode(code);
        String json = JSONObject.toJSONString(areas);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return Action.NONE;
    }
}
