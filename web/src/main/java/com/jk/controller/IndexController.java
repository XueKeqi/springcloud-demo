package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("user/list")
    public String userlist(){
        return "user/userList";
    }

}
