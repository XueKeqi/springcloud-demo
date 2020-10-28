package com.jk.service.impl;

import com.jk.config.RedisContent;
import com.jk.dao.EmpMapper;
import com.jk.entity.EmpEntity;
import com.jk.service.EmpService;
import com.jk.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<EmpEntity> findAll(@RequestBody EmpEntity user) {
        List<EmpEntity> userList = (List)redisUtil.get(RedisContent.USER_LIST_KEY + "_" + user.getUserName());
        if(userList == null || userList.isEmpty()) {
            userList = empMapper.findAll(user);
            redisUtil.set(RedisContent.USER_LIST_KEY + "_" + user.getUserName(), userList);
            // 设置key的过期时间
            redisUtil.expire(RedisContent.USER_LIST_KEY + "_" + user.getUserName(), 60);
        }

        return userList;
    }

    @Override
    public void addUser(EmpEntity user) {
        redisUtil.del(RedisContent.USER_LIST_KEY + "_*");
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        empMapper.addUser(user);
    }

    @Override
    public void updUser(EmpEntity user) {
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        empMapper.updUser(user);
    }

    @Override
    public EmpEntity HxUser(Integer id) {
        return empMapper.HxUser(id);
    }

    @Override
    public void delUser(Integer id) {
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        empMapper.delUser(id);
    }

}
