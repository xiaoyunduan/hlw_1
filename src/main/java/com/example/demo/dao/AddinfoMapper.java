package com.example.demo.dao;

import com.example.demo.model.Addinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AddinfoMapper {
    @Delete({
        "delete from addInfo",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into addInfo (userId, address, ",
        "aboutMe, upload)",
        "values (#{userId,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{aboutMe,jdbcType=VARCHAR}, #{upload,jdbcType=LONGVARBINARY})"
    })
    int insert(Addinfo record);

    @InsertProvider(type=AddinfoSqlProvider.class, method="insertSelective")
    int insertSelective(Addinfo record);

    @Select({
        "select",
        "userId, address, aboutMe, upload",
        "from addInfo",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="aboutMe", property="aboutMe", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload", property="upload", jdbcType=JdbcType.LONGVARBINARY)
    })
    Addinfo selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=AddinfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Addinfo record);

    @Update({
        "update addInfo",
        "set address = #{address,jdbcType=VARCHAR},",
          "aboutMe = #{aboutMe,jdbcType=VARCHAR},",
          "upload = #{upload,jdbcType=LONGVARBINARY}",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Addinfo record);

    @Update({
        "update addInfo",
        "set address = #{address,jdbcType=VARCHAR},",
          "aboutMe = #{aboutMe,jdbcType=VARCHAR}",
        "where userId = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Addinfo record);
}