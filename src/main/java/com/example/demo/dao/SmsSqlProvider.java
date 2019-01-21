package com.example.demo.dao;

import com.example.demo.model.Sms;
import org.apache.ibatis.jdbc.SQL;

public class SmsSqlProvider {

    public String insertSelective(Sms record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SMS");
        
        if (record.getSMSId() != null) {
            sql.VALUES("SMSId", "#{SMSId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.VALUES("reportTime", "#{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReportAreaPoint() != null) {
            sql.VALUES("reportAreaPoint", "#{reportAreaPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadId() != null) {
            sql.VALUES("HeadId", "#{headId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("AreaId", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getIsResolve() != null) {
            sql.VALUES("isResolve", "#{isResolve,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sms record) {
        SQL sql = new SQL();
        sql.UPDATE("SMS");
        
        if (record.getUserId() != null) {
            sql.SET("userId = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getReportTime() != null) {
            sql.SET("reportTime = #{reportTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReportAreaPoint() != null) {
            sql.SET("reportAreaPoint = #{reportAreaPoint,jdbcType=VARCHAR}");
        }
        
        if (record.getHeadId() != null) {
            sql.SET("HeadId = #{headId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("AreaId = #{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getIsResolve() != null) {
            sql.SET("isResolve = #{isResolve,jdbcType=INTEGER}");
        }
        
        sql.WHERE("SMSId = #{SMSId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}