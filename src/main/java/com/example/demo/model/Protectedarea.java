package com.example.demo.model;

public class Protectedarea {
    private Integer areaId;

    private Integer regionalHeadId;

    private String areaRange;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getRegionalHeadId() {
        return regionalHeadId;
    }

    public void setRegionalHeadId(Integer regionalHeadId) {
        this.regionalHeadId = regionalHeadId;
    }

    public String getAreaRange() {
        return areaRange;
    }

    public void setAreaRange(String areaRange) {
        this.areaRange = areaRange == null ? null : areaRange.trim();
    }
}