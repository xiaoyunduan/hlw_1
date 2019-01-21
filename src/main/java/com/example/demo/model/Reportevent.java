package com.example.demo.model;

import java.util.Date;

public class Reportevent {
    private Integer eventId;

    private Integer userId;

    private String reportAreaPoint;

    private Date reportTime;

    private Integer isResolve;

    private String emailMsg;

    private String title;

    private String headEmail;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReportAreaPoint() {
        return reportAreaPoint;
    }

    public void setReportAreaPoint(String reportAreaPoint) {
        this.reportAreaPoint = reportAreaPoint == null ? null : reportAreaPoint.trim();
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getIsResolve() {
        return isResolve;
    }

    public void setIsResolve(Integer isResolve) {
        this.isResolve = isResolve;
    }

    public String getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg == null ? null : emailMsg.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHeadEmail() {
        return headEmail;
    }

    public void setHeadEmail(String headEmail) {
        this.headEmail = headEmail == null ? null : headEmail.trim();
    }
}