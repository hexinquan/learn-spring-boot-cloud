package com.learn.boot.web.controller;

import com.learn.boot.web.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexinquan on 2018/12/19.
 */
@RestController
@RequestMapping(value = "/api")
public class DemoRestController {

    @RequestMapping(value = "/auto")
    public Map<String,Object> auto(Integer id, int no){
        Map<String,Object> map =new HashMap<>();
        map.put("id",id);
        map.put("no",no);
        return map;
    }
    @RequestMapping(value = "/obj")
    public Map<String,Object> obj(@RequestParam(value = "name",defaultValue = "hexinquan",required = true)String name){
        Map<String,Object> map =new HashMap<>();
        map.put("name",name);
        return map;
    }

    @GetMapping(value = "/user/{id}")
    public User get(@PathVariable Integer id){
        User user =new User();
        user.setName("heixnqian");
        user.setPassword("123456");
        return user;
    }
    @PutMapping(value = "/user")
    public boolean put(User user){
        System.out.println(user);
        return true;
    }
    @PostMapping(value = "/user")
    public boolean post(User user){
        System.out.println(user);
        return true;
    }
    @DeleteMapping(value = "/user")
    public boolean delete(User user){
        System.out.println(user);
        return true;
    }
}
