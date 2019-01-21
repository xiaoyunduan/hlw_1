package com.example.demo.dao;

import com.example.demo.model.Protectedarea;
import org.apache.ibatis.jdbc.SQL;

public class ProtectedareaSqlProvider {

    public String insertSelective(Protectedarea record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("protectedArea");
        
        if (record.getAreaId() != null) {
            sql.VALUES("AreaId", "#{areaId,jdbcType=INTEGER}");
        }
        
        if (record.getRegionalHeadId() != null) {
            sql.VALUES("regionalHeadId", "#{regionalHeadId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaRange() != null) {
            sql.VALUES("AreaRange", "#{areaRange,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Protectedarea record) {
        SQL sql = new SQL();
        sql.UPDATE("protectedArea");
        
        if (record.getRegionalHeadId() != null) {
            sql.SET("regionalHeadId = #{regionalHeadId,jdbcType=INTEGER}");
        }
        
        if (record.getAreaRange() != null) {
            sql.SET("AreaRange = #{areaRange,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("AreaId = #{areaId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}