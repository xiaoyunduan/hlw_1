package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel_id() != null) {
            sql.VALUES("level_id", "#{level_id,jdbcType=INTEGER}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getLevel_id() != null) {
            sql.SET("level_id = #{level_id,jdbcType=INTEGER}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        sql.WHERE("name = #{name,jdbcType=VARCHAR}");
        sql.WHERE("email = #{email,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}