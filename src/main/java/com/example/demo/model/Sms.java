package com.example.demo.model;

import java.util.Date;

public class Sms {
    private Integer SMSId;

    private Integer userId;

    private String content;

    private Date reportTime;

    private String reportAreaPoint;

    private Integer headId;

    private Integer areaId;

    private Integer isResolve;

    public Integer getSMSId() {
        return SMSId;
    }

    public void setSMSId(Integer SMSId) {
        this.SMSId = SMSId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportAreaPoint() {
        return reportAreaPoint;
    }

    public void setReportAreaPoint(String reportAreaPoint) {
        this.reportAreaPoint = reportAreaPoint == null ? null : reportAreaPoint.trim();
    }

    public Integer getHeadId() {
        return headId;
    }

    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getIsResolve() {
        return isResolve;
    }

    public void setIsResolve(Integer isResolve) {
        this.isResolve = isResolve;
    }
}