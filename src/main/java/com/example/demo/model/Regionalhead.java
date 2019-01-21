package com.example.demo.model;

public class Regionalhead {
    private Integer regionalHeadId;

    private String email;

    private String phoneNum;

    private Integer areaId;

    public Integer getRegionalHeadId() {
        return regionalHeadId;
    }

    public void setRegionalHeadId(Integer regionalHeadId) {
        this.regionalHeadId = regionalHeadId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}