package com.example.demo.dao;

import com.example.demo.model.Reportevent;

import java.awt.List;
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

public interface ReporteventMapper {
    @Delete({
        "delete from reportEvent",
        "where eventId = #{eventId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer eventId);

    @Insert({
        "insert into reportEvent (eventId, userId, ",
        "reportAreaPoint, reportTime, ",
        "isResolve, emailMsg, ",
        "title, headEmail)",
        "values (#{eventId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{reportAreaPoint,jdbcType=VARCHAR}, #{reportTime,jdbcType=TIMESTAMP}, ",
        "#{isResolve,jdbcType=INTEGER}, #{emailMsg,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{headEmail,jdbcType=VARCHAR})"
    })
    int insert(Reportevent record);

    @InsertProvider(type=ReporteventSqlProvider.class, method="insertSelective")
    int insertSelective(Reportevent record);

    @Select({
        "select",
        "eventId, userId, reportAreaPoint, reportTime, isResolve, emailMsg, title, headEmail",
        "from reportEvent",
        "where eventId = #{eventId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="eventId", property="eventId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER),
        @Result(column="emailMsg", property="emailMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="headEmail", property="headEmail", jdbcType=JdbcType.VARCHAR)
    })
    Reportevent selectByPrimaryKey(Integer eventId);

    @UpdateProvider(type=ReporteventSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Reportevent record);

    @Update({
        "update reportEvent",
        "set userId = #{userId,jdbcType=INTEGER},",
          "reportAreaPoint = #{reportAreaPoint,jdbcType=VARCHAR},",
          "reportTime = #{reportTime,jdbcType=TIMESTAMP},",
          "isResolve = #{isResolve,jdbcType=INTEGER},",
          "emailMsg = #{emailMsg,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "headEmail = #{headEmail,jdbcType=VARCHAR}",
        "where eventId = #{eventId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Reportevent record);
    
    @Select({
        "select*from reportEvent where userId = #{userId,jdbcType=INTEGER}",
       
    })
    @Results({
        @Result(column="eventId", property="eventId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER),
        @Result(column="emailMsg", property="emailMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="headEmail", property="headEmail", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Reportevent> selectAllByUserId(Integer i);

    @Select({
        "select*from reportEvent where headEmail = #{headEmail,jdbcType=VARCHAR}",
       
    })
    @Results({
        @Result(column="eventId", property="eventId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER),
        @Result(column="emailMsg", property="emailMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="headEmail", property="headEmail", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Reportevent> selectAllByHeadEmail(String email);
   
    
    @Select({
        "select*from reportEvent",
       
    })
    @Results({
        @Result(column="eventId", property="eventId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER),
        @Result(column="emailMsg", property="emailMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="headEmail", property="headEmail", jdbcType=JdbcType.VARCHAR)
    })
    ArrayList<Reportevent> selectAll();
    
}