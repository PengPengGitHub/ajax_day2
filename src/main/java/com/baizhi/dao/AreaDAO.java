package com.baizhi.dao;

import com.baizhi.entity.Area;

import java.util.List;

public interface AreaDAO {

    List<Area> findByCityCode(String code);
}
