package com.jk.dao;

import com.jk.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {


    List<EmpEntity> findAll(EmpEntity user);

    void addUser(EmpEntity user);

    void updUser(EmpEntity user);

    EmpEntity HxUser(Integer id);

    void delUser(Integer id);
}
