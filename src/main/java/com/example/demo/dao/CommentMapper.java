package com.example.demo.dao;

import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.model.UserKey;

import java.awt.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface CommentMapper {
    @Insert({
        "insert into comment (userId, content, ",
        "commentDate, userName)",
        "values (#{userId,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{commentDate,jdbcType=TIMESTAMP}, #{userName,jdbcType=VARCHAR})"
    })
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    int insertSelective(Comment record);
    
    @Delete({
        "delete from comment",
        "where userId = #{userId,jdbcType=INTEGER}"
          
    })
    int deleteByPrimaryKey(Integer id);
    
    @Select({
        "select",
        "userId, userName, content, commentDate",
        "from comment",
        "where userId = #{userId,jdbcType=INTEGER}"
         
    })
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="commentDate", property="commentDate", jdbcType=JdbcType.TIMESTAMP)
      
    })
 Comment selectByPrimaryKey(Integer id);
    
    
    @Select("select *from comment  order by commentDate desc")
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="commentDate", property="commentDate", jdbcType=JdbcType.TIMESTAMP)
      
    })
    ArrayList<Comment> getAllComment();
        
                
  
    
}