package com.example.demo.dao;

import com.example.demo.model.Level;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LevelMapper {
    @Delete({
        "delete from level",
        "where level_id = #{level_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer level_id);

    @Insert({
        "insert into level (level_id, level_name)",
        "values (#{level_id,jdbcType=INTEGER}, #{level_name,jdbcType=VARCHAR})"
    })
    int insert(Level record);

    @InsertProvider(type=LevelSqlProvider.class, method="insertSelective")
    int insertSelective(Level record);

    @Select({
        "select",
        "level_id, level_name",
        "from level",
        "where level_id = #{level_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="level_id", property="level_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="level_name", property="level_name", jdbcType=JdbcType.VARCHAR)
    })
    Level selectByPrimaryKey(Integer level_id);

    @UpdateProvider(type=LevelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Level record);

    @Update({
        "update level",
        "set level_name = #{level_name,jdbcType=VARCHAR}",
        "where level_id = #{level_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Level record);
}