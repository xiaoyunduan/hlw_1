package com.example.demo.dao;

import com.example.demo.model.Sms;

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

public interface SmsMapper {
    @Delete({
        "delete from SMS",
        "where SMSId = #{SMSId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer SMSId);

    @Insert({
        "insert into SMS (SMSId, userId, ",
        "content, reportTime, ",
        "reportAreaPoint, HeadId,isResolve)",
        "values (#{SMSId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{reportTime,jdbcType=TIMESTAMP}, ",
        "#{reportAreaPoint,jdbcType=VARCHAR}, #{headId,jdbcType=INTEGER},#{isResolve,jdbcType=INTEGER})"        
    })
    int insert(Sms record);

    @InsertProvider(type=SmsSqlProvider.class, method="insertSelective")
    int insertSelective(Sms record);

    
    @Select({
        "select *",
        
        "from SMS"
       
    })
    @Results({
        @Result(column="SMSId", property="SMSId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="HeadId", property="headId", jdbcType=JdbcType.INTEGER),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER)
    })
    
    ArrayList<Sms> selectAll();
    
    @Select({
        "select",
        "SMSId, userId, content, reportTime, reportAreaPoint, HeadId",
        "from SMS",
        "where SMSId = #{SMSId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="SMSId", property="SMSId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="HeadId", property="headId", jdbcType=JdbcType.INTEGER),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER)
    })
    Sms selectByPrimaryKey(Integer SMSId);
    
    @Select({
        "select",
        "SMSId, userId, content, reportTime, reportAreaPoint, HeadId,isResolve",
        "from SMS",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="SMSId", property="SMSId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="HeadId", property="headId", jdbcType=JdbcType.INTEGER),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER)
    })
    
    ArrayList<Sms> selectByUserId(Integer userId);
    
    
    @Select({
        "select",
        "SMSId, userId, content, reportTime, reportAreaPoint, HeadId,isResolve",
        "from SMS",
        "where HeadId = #{HeadId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="SMSId", property="SMSId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="reportTime", property="reportTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reportAreaPoint", property="reportAreaPoint", jdbcType=JdbcType.VARCHAR),
        @Result(column="HeadId", property="headId", jdbcType=JdbcType.INTEGER),
        @Result(column="isResolve", property="isResolve", jdbcType=JdbcType.INTEGER)
    })
    
    ArrayList<Sms> selectByHeadId(Integer HeadId);

    

    @UpdateProvider(type=SmsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sms record);

    @Update({
        "update SMS",
        "set userId = #{userId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "reportTime = #{reportTime,jdbcType=TIMESTAMP},",
          "reportAreaPoint = #{reportAreaPoint,jdbcType=VARCHAR},",
          "HeadId = #{headId,jdbcType=INTEGER}",
          "isResolve=#{isResolve,jdbcType=INTEGER}",
        "where SMSId = #{SMSId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sms record);
}