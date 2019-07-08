package com.fegin.server.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInfo {
    private String userName;
    private Integer age;
    private Integer userId;
    private Date userBirth;
}
