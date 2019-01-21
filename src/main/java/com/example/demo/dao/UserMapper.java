package com.example.demo.dao;

import com.example.demo.model.User;
import com.example.demo.model.UserKey;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}",
          "or name = #{name,jdbcType=VARCHAR}",
          "or email = #{email,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(UserKey key);

    @Insert({
        "insert into user (id, name, ",
        "email, level_id, ",
        "pwd)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{level_id,jdbcType=INTEGER}, ",
        "#{pwd,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "id, name, email, level_id, pwd",
        "from user",
        "where id = #{id,jdbcType=INTEGER}",
          "or name = #{name,jdbcType=VARCHAR}",
          "or email = #{email,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="level_id", property="level_id", jdbcType=JdbcType.INTEGER),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(UserKey key);
    
    
    
    @Select({
        "select *",
        
        "from user"
       
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="level_id", property="level_id", jdbcType=JdbcType.INTEGER),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<User> selectAllUser();
    
    @Select({
        "select",
        "id, name, email, level_id, pwd",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
          
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="level_id", property="level_id", jdbcType=JdbcType.INTEGER),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR)
    })
    User selectUserById(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
          "set pwd = #{pwd,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}",
          "or name = #{name,jdbcType=VARCHAR}",
          "or email = #{email,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}