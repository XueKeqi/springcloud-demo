package com.jk.controller;

import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/selectUserInfoByCode")
    public SysUser selectUserInfoByCode(@RequestParam String userCode) {
        return userService.selectUserInfoByCode(userCode);
    }

    @RequestMapping("/selectTreeList")
    public List<Tree> selectTreeList(@RequestParam Integer userId){
        return userService.selectTreeList(userId);
    }

    @RequestMapping("/selectPowerKeyList")
    public List<String> selectPowerKeyList(@RequestParam Integer userId){
        return userService.selectPowerKeyList(userId);
    }


    @RequestMapping("/list")
    public List<UserEntity> list(@RequestBody UserEntity paramUser){
        System.out.println(paramUser);
        UserEntity user = new UserEntity();
        user.setUserId(1);
        user.setUserName("李新");
        user.setPassword("123");
        List<UserEntity> list = new ArrayList<UserEntity>();
        list.add(user);
        return list;
    }
}
