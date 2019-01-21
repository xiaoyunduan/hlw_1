package com.example.demo.dao;

import com.example.demo.model.Level;
import org.apache.ibatis.jdbc.SQL;

public class LevelSqlProvider {

    public String insertSelective(Level record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("level");
        
        if (record.getLevel_id() != null) {
            sql.VALUES("level_id", "#{level_id,jdbcType=INTEGER}");
        }
        
        if (record.getLevel_name() != null) {
            sql.VALUES("level_name", "#{level_name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Level record) {
        SQL sql = new SQL();
        sql.UPDATE("level");
        
        if (record.getLevel_name() != null) {
            sql.SET("level_name = #{level_name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("level_id = #{level_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}