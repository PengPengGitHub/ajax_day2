package com.baizhi.entity;

public class City {
    private Integer id;
    private String name;
    private String code;
    private String provincecode;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", provincecode='" + provincecode + '\'' +
                '}';
    }

    public City() {
    }

    public City(Integer id, String name, String code, String provincecode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.provincecode = provincecode;
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

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
}
