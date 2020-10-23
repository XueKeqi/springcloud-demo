package com.jk.dao;

import com.jk.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<UserEntity> findAll(@RequestBody UserEntity user);

    void addUser(UserEntity user);

    UserEntity HxUser(Integer id);

    void delUser(Integer id);

    void updUser(UserEntity user);
}
