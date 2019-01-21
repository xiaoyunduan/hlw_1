package com.example.demo.dao;

import com.example.demo.model.Addinfo;
import org.apache.ibatis.jdbc.SQL;

public class AddinfoSqlProvider {

    public String insertSelective(Addinfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("addInfo");
        
        if (record.getUserId() != null) {
            sql.VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAboutMe() != null) {
            sql.VALUES("aboutMe", "#{aboutMe,jdbcType=VARCHAR}");
        }
        
        if (record.getUpload() != null) {
            sql.VALUES("upload", "#{upload,jdbcType=LONGVARBINARY}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Addinfo record) {
        SQL sql = new SQL();
        sql.UPDATE("addInfo");
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAboutMe() != null) {
            sql.SET("aboutMe = #{aboutMe,jdbcType=VARCHAR}");
        }
        
        if (record.getUpload() != null) {
            sql.SET("upload = #{upload,jdbcType=LONGVARBINARY}");
        }
        
        sql.WHERE("userId = #{userId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}