package com.jk.service;

import com.jk.entity.EmpEntity;

import java.util.List;

public interface EmpService {
    List<EmpEntity> findAll(EmpEntity user);

    void updUser(EmpEntity user);

    void addUser(EmpEntity user);

    EmpEntity HxUser(Integer id);

    void delUser(Integer id);
}
