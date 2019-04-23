package com.baizhi.test;

import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestProvinceService {

    @Test
    public  void test(){

        ProvinceServiceImpl provinceService = new ProvinceServiceImpl();
        List<Province> all = provinceService.findAll();
        for (Province province : all) {
            System.out.println(province);
        }

    }

}
