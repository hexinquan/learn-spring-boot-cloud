package com.fegin.server.controller;

import com.fegin.server.domain.UserInfo;
import com.fegin.server.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Value("${lable}")
    private String lable;
    @RequestMapping(value = "/getUserInfo/{userId}")
    public UserInfo getUserInfo(@PathVariable(value = "userId")Integer userId){
      return  userInfoService.getUserInfo(userId);
    }
    @RequestMapping(value = "/config")
    public String getConfig(){
        return "config->"+lable;
    }
}
