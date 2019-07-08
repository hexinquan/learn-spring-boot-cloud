package com.fegin.server.service.impl;

import com.fegin.server.domain.UserInfo;
import com.fegin.server.mapper.UserInfoMapper;
import com.fegin.server.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(Integer userId) {
        return userInfoMapper.getUserInfo(userId);
    }
}
