package com.jk.service;

import com.jk.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserEntity> findAll(@RequestBody UserEntity user);

    void addUser(UserEntity user);

    UserEntity HxUser(Integer id);

    void delUser(Integer id);

    void updUser(UserEntity user);
}
