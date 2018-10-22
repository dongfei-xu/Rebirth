package com.hk.rebirth.dao;

import com.hk.rebirth.pojo.ReUserInfoDo;
import com.hk.rebirth.pojo.ReUserInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ReUserInfoDoMapper {
    long countByExample(ReUserInfoDoExample example);

    int deleteByExample(ReUserInfoDoExample example);

    @Delete({
        "delete from re_user_info",
        "where increment_id = #{incrementId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer incrementId);

    @Insert({
        "insert into re_user_info (increment_id, sequence_id, ",
        "user_name, password, ",
        "create_time, update_time)",
        "values (#{incrementId,jdbcType=INTEGER}, #{sequenceId,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(ReUserInfoDo record);

    int insertSelective(ReUserInfoDo record);

    List<ReUserInfoDo> selectByExample(ReUserInfoDoExample example);

    @Select({
        "select",
        "increment_id, sequence_id, user_name, password, create_time, update_time",
        "from re_user_info",
        "where increment_id = #{incrementId,jdbcType=INTEGER}"
    })
    @ResultMap("com.hk.rebirth.dao.ReUserInfoDoMapper.BaseResultMap")
    ReUserInfoDo selectByPrimaryKey(Integer incrementId);

    int updateByExampleSelective(@Param("record") ReUserInfoDo record, @Param("example") ReUserInfoDoExample example);

    int updateByExample(@Param("record") ReUserInfoDo record, @Param("example") ReUserInfoDoExample example);

    int updateByPrimaryKeySelective(ReUserInfoDo record);

    @Update({
        "update re_user_info",
        "set sequence_id = #{sequenceId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where increment_id = #{incrementId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReUserInfoDo record);
}