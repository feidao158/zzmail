package com.zw.mapper;

import com.zw.pojo.AccessToken;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccessTokenMapper {

     @Select("SELECT * FROM access_token")
     AccessToken selectAccessToken();

     @Update("UPDATE access_token set access_token = #{accessToken},expires_in = #{expiresIn},gmt_modified = #{gmtModified} WHERE id =1 ")
     int updateAccessToken(AccessToken accessToken);

}
