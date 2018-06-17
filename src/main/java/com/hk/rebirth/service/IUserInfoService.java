package com.hk.rebirth.service;

import com.hk.rebirth.pojo.UserInfoPo;

import java.util.List;

public interface IUserInfoService {

    int insertSelective(UserInfoPo userInfoPo);

    int updateSelective(UserInfoPo userInfoPo, String userInfoSequence);

    int updateSelective(UserInfoPo userInfoPo, String userInfoSequence, List<String> start);

    UserInfoPo select(String userInfoSequence);

    List<UserInfoPo> select();

    int delete(String userInfoSequence);

}
