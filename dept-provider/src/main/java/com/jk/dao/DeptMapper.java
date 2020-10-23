package com.jk.dao;

import com.jk.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<UserEntity> findAll();
}
