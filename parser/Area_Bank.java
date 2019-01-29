package com.example.calsys.retro_custom_class.parser;

public class Area_Bank {


    private String area_name;

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    private String area_id;

    public Area_Bank(String area_name, String area_id) {
        this.area_name = area_name;
        this.area_id = area_id;
    }

    @Override
    public String toString() {
        return area_name;
    }
}
