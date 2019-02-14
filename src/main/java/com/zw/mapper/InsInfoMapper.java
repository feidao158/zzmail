package com.zw.mapper;

import org.apache.ibatis.annotations.Insert;

public interface InsInfoMapper {

    @Insert("INSERT INTO ins_info(from_user,url) VALUES #{fromUser},#{url}")
     int insertData(String fromUser,String url);

}
