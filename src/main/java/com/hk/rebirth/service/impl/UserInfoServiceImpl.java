package com.hk.rebirth.service.impl;

import com.hk.rebirth.dao.UserInfoPoMapper;
import com.hk.rebirth.pojo.UserInfoPo;
import com.hk.rebirth.pojo.UserInfoPoExample;
import com.hk.rebirth.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoPoMapper userInfoPoMapper;

    @Override
    @Transactional
    public int insertSelective(UserInfoPo userInfoPo) {
        int i = userInfoPoMapper.insertSelective(userInfoPo);

        if(true){
            throw new RuntimeException("insert 抛异常了");
        }
        return i;
    }

    @Override
    @Transactional
    public int insert(UserInfoPo userInfoPo) {
        int i = userInfoPoMapper.insertSelective(userInfoPo);
        return i;
    }

    @Override
    public int updateSelective(UserInfoPo userInfoPo, String userInfoSequence) {
        UserInfoPoExample example = new UserInfoPoExample();
        example.createCriteria().andUserIdEqualTo(userInfoSequence);
        return userInfoPoMapper.updateByExample(userInfoPo, example);
    }

    @Override
    public int updateSelective(UserInfoPo userInfoPo, String userInfoSequence, List<String> start) {
        UserInfoPoExample example = new UserInfoPoExample();
        example.createCriteria().andUserIdEqualTo(userInfoSequence);
        return userInfoPoMapper.updateByExample(userInfoPo, example);
    }

    @Override
    public UserInfoPo select(String userInfoSequence) {
        return userInfoPoMapper.selectByPrimaryKey(userInfoSequence);
    }

    @Override
    public List<UserInfoPo> select() {
        UserInfoPoExample example = new UserInfoPoExample();
        return userInfoPoMapper.selectByExample(example);
    }

    @Override
    public int delete(String userInfoSequence) {
        return userInfoPoMapper.deleteByPrimaryKey(userInfoSequence);
    }
}
