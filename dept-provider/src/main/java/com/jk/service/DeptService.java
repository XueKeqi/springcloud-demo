package com.jk.service;

import com.jk.entity.DeptEntity;
import com.jk.entity.UserEntity;

import java.util.List;

public interface DeptService {
    List<UserEntity> findAll();

    void updDept(DeptEntity dept);

    void addDept(DeptEntity dept);

    UserEntity HxDept(Integer id);

    void delDept(Integer id);
}
