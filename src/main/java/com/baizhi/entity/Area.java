package com.baizhi.entity;

public class Area {

    private Integer id;
    private String name;
    private String code;
    private String cityCode;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }

    public Area() {
    }

    public Area(Integer id, String name, String code, String cityCode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cityCode = cityCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
