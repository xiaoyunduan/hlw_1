package com.example.demo.dao;

import java.awt.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.model.Statistics;

public interface StatisticsMapper {

	

    @Select({
    	"select a.click_date,ifnull(b.count,0) as count,ifnull(b.Area_1,0) as Area_1,ifnull(b.Area_2,0) as Area_2,ifnull(b.Area_3,0) as Area_3,ifnull(b.Area_4,0) as Area_4,ifnull(b.Area_5,0) as Area_5",
    	"from (",
    	    "SELECT curdate() as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 1 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 2 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 3 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 4 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 5 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 6 day) as click_date",
    	") a left join (",
    	  "select date(reportTime) as datetime, count(*) as count,sum(AreaId=1) AS Area_1,sum(AreaId=2) AS Area_2,sum(AreaId=3) AS Area_3,sum(AreaId=4) AS Area_4,sum(AreaId=5) AS Area_5",
    	  "from reportEvent",
    	  "group by date(reportTime)",
    	") b on a.click_date = b.datetime"
    })
    @Results({
        @Result(column="click_date", property="d", jdbcType=JdbcType.DATE, id=true),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_1", property="Area_1", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_2", property="Area_2", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_3", property="Area_3", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_4", property="Area_4", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Area_5", property="Area_5", jdbcType=JdbcType.INTEGER, id=true),
    })
    ArrayList<Statistics>  StatisticsEmail();
    
    
    @Select({
    	"select a.click_date,ifnull(b.count,0) as count,ifnull(b.Area_1,0) as Area_1,ifnull(b.Area_2,0) as Area_2,ifnull(b.Area_3,0) as Area_3,ifnull(b.Area_4,0) as Area_4,ifnull(b.Area_5,0) as Area_5",
    	"from (",
    	    "SELECT curdate() as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 1 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 2 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 3 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 4 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 5 day) as click_date",
    	    "union all",
    	    "SELECT date_sub(curdate(), interval 6 day) as click_date",
    	") a left join (",
    	  "select date(reportTime) as datetime, count(*) as count,sum(AreaId=1) AS Area_1,sum(AreaId=2) AS Area_2,sum(AreaId=3) AS Area_3,sum(AreaId=4) AS Area_4,sum(AreaId=5) AS Area_5",
    	  "from SMS",
    	  "group by date(reportTime)",
    	") b on a.click_date = b.datetime"
    })
    @Results({
        @Result(column="click_date", property="d", jdbcType=JdbcType.DATE, id=true),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER, id=true),
        
    })
    ArrayList<Statistics>  StatisticsSMS();
    
}
