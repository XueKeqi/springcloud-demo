package com.jk.service;

import com.jk.entity.UserEntity;
import com.jk.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "userclient",fallback = UserHystrix.class)
public interface UserService {

    @RequestMapping("user/findOne")
    public  String findOne();

    @GetMapping("user/findAll")
    public List<UserEntity> findAll(@RequestBody UserEntity user);

    @GetMapping("user/saveUser")
    public void saveUser(@RequestBody UserEntity user);

    @GetMapping("user/HxUser")
    public UserEntity HxUser(@RequestParam Integer id);


    @GetMapping("user/delUser")
    public void delUser(@RequestParam Integer id);


}
