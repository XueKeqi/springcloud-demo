package com.jk.service;

import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.entity.UserEntity;
import com.jk.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "userclient", fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping("/show")
    String show();

    @RequestMapping("/list")
    public List<UserEntity> list(@RequestBody UserEntity paramUser);

    @RequestMapping("/selectUserInfoByCode")
    SysUser selectUserInfoByCode(@RequestParam String userCode);

    @RequestMapping("/selectTreeList")
    List<Tree> selectTreeList(@RequestParam Integer userId);

    @RequestMapping("/selectPowerKeyList")
    List<String> selectPowerKeyList(@RequestParam Integer userId);
}
