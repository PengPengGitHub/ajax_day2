package com.baizhi.service;

import com.baizhi.dao.AreaDAO;
import com.baizhi.entity.Area;
import com.baizhi.util.MybatisUtils;

import java.util.List;

public class AreaServiceImpl implements AreaService {

    @Override
    public List<Area> findByCityCode(String code) {
        AreaDAO areaDAO = MybatisUtils.getSqlSession().getMapper(AreaDAO.class);
        List<Area> areas = areaDAO.findByCityCode(code);
        MybatisUtils.close();
        return areas;
    }
}
