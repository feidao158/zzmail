package com.zw.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface InsInfoMapper {

    @Insert("INSERT INTO ins_info(from_user,url) VALUES (#{fromUser},#{url})")
     int insertData(@Param("fromUser") String fromUser, @Param("url") String url);

    @Select("select url from ins_info where from_user =  #{fromUser}  order by save_time desc limit 1")
    String selectUrl(@Param("fromUser") String fromUser);




}
