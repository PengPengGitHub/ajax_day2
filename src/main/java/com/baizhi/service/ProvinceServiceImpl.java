package com.baizhi.service;

import com.baizhi.dao.ProvinceDAO;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtils;

import java.util.List;

public class ProvinceServiceImpl implements  ProvinceService {


    @Override
    public List<Province> findAll() {
        ProvinceDAO provinceDAO = MybatisUtils.getSqlSession().getMapper(ProvinceDAO.class);
        List<Province> provinces = provinceDAO.findAll();
        MybatisUtils.close();
        return provinces;
    }
}
