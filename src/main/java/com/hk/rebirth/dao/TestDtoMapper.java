package com.hk.rebirth.dao;

import com.hk.rebirth.pojo.TestDto;
import com.hk.rebirth.pojo.TestDtoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TestDtoMapper {
    long countByExample(TestDtoExample example);

    int deleteByExample(TestDtoExample example);

    @Delete({
        "delete from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into test (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(TestDto record);

    int insertSelective(TestDto record);

    List<TestDto> selectByExample(TestDtoExample example);

    @Select({
        "select",
        "id, name",
        "from test",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.hk.rebirth.dao.TestDtoMapper.BaseResultMap")
    TestDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestDto record, @Param("example") TestDtoExample example);

    int updateByExample(@Param("record") TestDto record, @Param("example") TestDtoExample example);

    int updateByPrimaryKeySelective(TestDto record);

    @Update({
        "update test",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TestDto record);
}