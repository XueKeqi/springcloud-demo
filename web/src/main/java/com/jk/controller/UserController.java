package com.jk.controller;

import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Resource
    private UserService userService;


    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("user/findAll")
    public List<UserEntity> findAll(UserEntity user){
        List<UserEntity> list = userService.findAll(user);
        return list;
    }


    /**
     * 新增+修改
     * @param user
     */
    @RequestMapping("user/saveUser")
    public void saveUser(UserEntity user){
        userService.saveUser(user);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("user/HxUser")
    public UserEntity HxUser(@RequestParam Integer id){
        return userService.HxUser(id);
    }


    /**
     * 删除
     * @param id
     */
    @RequestMapping("user/delUser")
    public void delUser(Integer id){
        userService.delUser(id);
    }


    /**
     * 测试
     */
    @RequestMapping("test")
    public String test(){
        return userService.findOne();
    }
}
