package com.example.demo.dao;

import com.example.demo.model.Reportevent;
import org.apache.ibatis.jdbc.SQL;

public class ReporteventSqlProvider {

    public String insertSelective(Reportevent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("reportEvent");
        
        if (record.getEventId() != null) {
            sql.VALUES("eventId", "#{eventId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getReportAreaPoint() != null) {
            sql.VALUES("reportAreaPoint", "#{reportAreaPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.VALUES("reportTime", "#{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsResolve() != null) {
            sql.VALUES("isResolve", "#{isResolve,jdbcType=INTEGER}");
        }
        
        if (record.getEmailMsg() != null) {
            sql.VALUES("emailMsg", "#{emailMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadEmail() != null) {
            sql.VALUES("headEmail", "#{headEmail,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Reportevent record) {
        SQL sql = new SQL();
        sql.UPDATE("reportEvent");
        
        if (record.getUserId() != null) {
            sql.SET("userId = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getReportAreaPoint() != null) {
            sql.SET("reportAreaPoint = #{reportAreaPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.SET("reportTime = #{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsResolve() != null) {
            sql.SET("isResolve = #{isResolve,jdbcType=INTEGER}");
        }
        
        if (record.getEmailMsg() != null) {
            sql.SET("emailMsg = #{emailMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadEmail() != null) {
            sql.SET("headEmail = #{headEmail,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("eventId = #{eventId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}