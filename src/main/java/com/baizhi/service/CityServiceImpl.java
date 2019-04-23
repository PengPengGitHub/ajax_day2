package com.baizhi.service;

import com.baizhi.dao.CityDAO;
import com.baizhi.entity.City;
import com.baizhi.util.MybatisUtils;

import java.util.List;

public class CityServiceImpl implements CityService {

    @Override
    public List<City> findByProvinceCode(String code) {
        CityDAO mapper = MybatisUtils.getSqlSession().getMapper(CityDAO.class);
        List<City> cities = mapper.findByProvinceCode(code);
        MybatisUtils.close();
        return cities;
    }
}
