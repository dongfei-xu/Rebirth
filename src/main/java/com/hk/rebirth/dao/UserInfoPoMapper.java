package com.hk.rebirth.dao;

import com.hk.rebirth.pojo.UserInfoPo;
import com.hk.rebirth.pojo.UserInfoPoExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoPoMapper {
    long countByExample(UserInfoPoExample example);

    int deleteByExample(UserInfoPoExample example);

    @Delete({
        "delete from userinfo",
        "where user_Id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into userinfo (user_Id, user_Name, ",
        "password, mobile_Phone, ",
        "address, create_Time)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{mobilePhone,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserInfoPo record);

    int insertSelective(UserInfoPo record);

    List<UserInfoPo> selectByExample(UserInfoPoExample example);

    @Select({
        "select",
        "user_Id, user_Name, password, mobile_Phone, address, create_Time",
        "from userinfo",
        "where user_Id = #{userId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.hk.rebirth.dao.UserInfoPoMapper.BaseResultMap")
    UserInfoPo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);

    int updateByExample(@Param("record") UserInfoPo record, @Param("example") UserInfoPoExample example);

    int updateByPrimaryKeySelective(UserInfoPo record);

    @Update({
        "update userinfo",
        "set user_Name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "mobile_Phone = #{mobilePhone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_Time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_Id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserInfoPo record);
}