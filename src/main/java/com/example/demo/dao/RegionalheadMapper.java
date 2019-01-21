package com.example.demo.dao;

import com.example.demo.model.Regionalhead;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RegionalheadMapper {
    @Delete({
        "delete from regionalHead",
        "where regionalHeadId = #{regionalHeadId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer regionalHeadId);

    @Insert({
        "insert into regionalHead (regionalHeadId, email, ",
        "phoneNum, AreaId)",
        "values (#{regionalHeadId,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, ",
        "#{phoneNum,jdbcType=VARCHAR}, #{areaId,jdbcType=INTEGER})"
    })
    int insert(Regionalhead record);

    @InsertProvider(type=RegionalheadSqlProvider.class, method="insertSelective")
    int insertSelective(Regionalhead record);

    @Select({
        "select",
        "regionalHeadId, email, phoneNum, AreaId",
        "from regionalHead",
        "where regionalHeadId = #{regionalHeadId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="regionalHeadId", property="regionalHeadId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phoneNum", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="AreaId", property="areaId", jdbcType=JdbcType.INTEGER)
    })
    Regionalhead selectByPrimaryKey(Integer regionalHeadId);
    
    
    @Select({
        "select",
        "regionalHeadId, email, phoneNum, AreaId",
        "from regionalHead",
        "where phoneNum = #{phoneNum,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="regionalHeadId", property="regionalHeadId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phoneNum", property="phoneNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="AreaId", property="areaId", jdbcType=JdbcType.INTEGER)
    })
    Regionalhead selectByPhoneNum(String phoneNum);

    @UpdateProvider(type=RegionalheadSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Regionalhead record);

    @Update({
        "update regionalHead",
        "set email = #{email,jdbcType=VARCHAR},",
          "phoneNum = #{phoneNum,jdbcType=VARCHAR},",
          "AreaId = #{areaId,jdbcType=INTEGER}",
        "where regionalHeadId = #{regionalHeadId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Regionalhead record);
}