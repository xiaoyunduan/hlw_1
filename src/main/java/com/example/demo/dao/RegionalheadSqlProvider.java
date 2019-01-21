package com.example.demo.dao;

import com.example.demo.model.Regionalhead;
import org.apache.ibatis.jdbc.SQL;

public class RegionalheadSqlProvider {

    public String insertSelective(Regionalhead record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("regionalHead");
        
        if (record.getRegionalHeadId() != null) {
            sql.VALUES("regionalHeadId", "#{regionalHeadId,jdbcType=INTEGER}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNum() != null) {
            sql.VALUES("phoneNum", "#{phoneNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.VALUES("AreaId", "#{areaId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Regionalhead record) {
        SQL sql = new SQL();
        sql.UPDATE("regionalHead");
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNum() != null) {
            sql.SET("phoneNum = #{phoneNum,jdbcType=VARCHAR}");
        }
        
        if (record.getAreaId() != null) {
            sql.SET("AreaId = #{areaId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("regionalHeadId = #{regionalHeadId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}