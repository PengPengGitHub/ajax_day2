package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import com.baizhi.service.CityServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityAction {

    private String code;
    private CityService cityService = new CityServiceImpl();
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String findCityByProvinceCode() throws IOException {
        List<City> byProvinceCode = cityService.findByProvinceCode(code);
        //转换json
        String jsonString = JSONObject.toJSONString(byProvinceCode);
        //获取response响应
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(jsonString);
        return Action.NONE;
    }
}
