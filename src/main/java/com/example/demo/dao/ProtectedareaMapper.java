package com.example.demo.dao;

import com.example.demo.model.Protectedarea;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProtectedareaMapper {
    @Delete({
        "delete from protectedArea",
        "where AreaId = #{areaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaId);

    @Insert({
        "insert into protectedArea (AreaId, regionalHeadId, ",
        "AreaRange)",
        "values (#{areaId,jdbcType=INTEGER}, #{regionalHeadId,jdbcType=INTEGER}, ",
        "#{areaRange,jdbcType=VARCHAR})"
    })
    int insert(Protectedarea record);

    @InsertProvider(type=ProtectedareaSqlProvider.class, method="insertSelective")
    int insertSelective(Protectedarea record);

    @Select({
        "select",
        "AreaId, regionalHeadId, AreaRange",
        "from protectedArea",
        "where AreaId = #{areaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="AreaId", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="regionalHeadId", property="regionalHeadId", jdbcType=JdbcType.INTEGER),
        @Result(column="AreaRange", property="areaRange", jdbcType=JdbcType.VARCHAR)
    })
    Protectedarea selectByPrimaryKey(Integer areaId);

    @UpdateProvider(type=ProtectedareaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Protectedarea record);

    @Update({
        "update protectedArea",
        "set regionalHeadId = #{regionalHeadId,jdbcType=INTEGER},",
          "AreaRange = #{areaRange,jdbcType=VARCHAR}",
        "where AreaId = #{areaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Protectedarea record);
}