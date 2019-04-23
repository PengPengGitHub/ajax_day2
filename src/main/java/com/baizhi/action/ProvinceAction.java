package com.baizhi.action;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import com.baizhi.service.ProvinceServiceImpl;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProvinceAction {

    private ProvinceService provinceService = new ProvinceServiceImpl();

    public String findAll() throws IOException {
        List<Province> provinces = provinceService.findAll();
        //转换json
        String json = JSONObject.toJSONString(provinces);
        //获取response
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return Action.NONE;
    }
}
