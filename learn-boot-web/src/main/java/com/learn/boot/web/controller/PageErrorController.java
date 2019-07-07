package com.learn.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by hexinquan on 2018/12/21.
 */
@Controller(value = "/error")
public class PageErrorController {
    @GetMapping(value = "/error404")
    public String error(){
        return "error";
    }
}
