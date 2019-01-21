package com.example.demo.dao;

import com.example.demo.model.Comment;
import org.apache.ibatis.jdbc.SQL;

public class CommentSqlProvider {

    public String insertSelective(Comment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comment");
        
        if (record.getUserId() != null) {
            sql.VALUES("userId", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentDate() != null) {
            sql.VALUES("commentDate", "#{commentDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("userName", "#{userName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}