package com.jk.service.impl;

import com.jk.dao.DeptMapper;
import com.jk.entity.DeptEntity;
import com.jk.entity.UserEntity;
import com.jk.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptSericeImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<UserEntity> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void updDept(DeptEntity dept) {

    }

    @Override
    public void addDept(DeptEntity dept) {

    }

    @Override
    public UserEntity HxDept(Integer id) {
        return null;
    }

    @Override
    public void delDept(Integer id) {

    }
}
