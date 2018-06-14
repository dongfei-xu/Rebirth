package com.hk.rebirth.service.impl;

import com.hk.rebirth.dao.TestDtoMapper;
import com.hk.rebirth.service.ITestService;
import org.springframework.stereotype.Service;
import com.hk.rebirth.pojo.TestDto;
import com.hk.rebirth.pojo.TestDtoExample;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author:dongfei.xu
 * @Date: 2018/6/14 15:58
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    TestDtoMapper testDtoMapper;

    @Override
    public List<TestDto> select() {
        TestDtoExample example = new TestDtoExample();
        return testDtoMapper.selectByExample(example);
    }
}
