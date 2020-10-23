package com.jk.service.impl;

import com.jk.config.RedisContent;
import com.jk.dao.UserMapper;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import com.jk.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<UserEntity> findAll(@RequestBody UserEntity user) {
        List<UserEntity> userList = (List)redisUtil.get(RedisContent.USER_LIST_KEY + "_" + user.getUserName());
        if(userList == null || userList.isEmpty()) {
            userList = userMapper.findAll(user);
            redisUtil.set(RedisContent.USER_LIST_KEY + "_" + user.getUserName(), userList);
            // 设置key的过期时间
            redisUtil.expire(RedisContent.USER_LIST_KEY + "_" + user.getUserName(), 60);
        }

        return userList;
    }

    @Override
    public void addUser(UserEntity user) {
        redisUtil.del(RedisContent.USER_LIST_KEY + "_*");
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        userMapper.addUser(user);
    }

    @Override
    public void updUser(UserEntity user) {
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        userMapper.updUser(user);
    }

    @Override
    public UserEntity HxUser(Integer id) {
        return userMapper.HxUser(id);
    }

    @Override
    public void delUser(Integer id) {
        redisUtil.delAllKeys(RedisContent.USER_LIST_KEY + "_*");
        userMapper.delUser(id);
    }




}
