package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

public interface CityService {

    List<City> findByProvinceCode(String code);
}
