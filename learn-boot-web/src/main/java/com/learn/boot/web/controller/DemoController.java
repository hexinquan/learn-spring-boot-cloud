package com.learn.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexinquan on 2018/12/19.
 */
@Controller
@RequestMapping(value = "/freemark")
public class DemoController {
    @GetMapping(value = "/index")
    public String index(Model model){
        Map<String,Object> map =new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",10);
        model.addAttribute("user",map);
        return "index";
    }
}
