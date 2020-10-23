package com.jk.hystrix;

import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;



@Component
public class UserHystrix implements UserService {

    @Resource
    private UserService userService;


    @Override
    public String findOne() {
        return "error/show";
    }

    @Override
    public List<UserEntity> findAll(UserEntity user) {



        return userService.findAll(user);
    }

    @Override
    public void saveUser(UserEntity user) {
        userService.saveUser(user);
    }

    @Override
    public UserEntity HxUser(Integer id) {
        return userService.HxUser(id);
    }

    @Override
    public void delUser(Integer id) {
        userService.delUser(id);
    }





}
