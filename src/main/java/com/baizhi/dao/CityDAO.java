package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

public interface CityDAO {

    List<City> findByProvinceCode(String code);
}
