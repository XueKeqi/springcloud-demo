package com.jk.hystrix;

import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //将熔断器类注入到spring容器中
public class UserServiceHystrix implements UserService {

    @Override
    public String show() {
        return "网络问题，请稍后重试。";
    }

    @Override
    public List<UserEntity> list(UserEntity user) {
        return null;
    }

    @Override
    public SysUser selectUserInfoByCode(String userCode) {
        return null;
    }

    @Override
    public List<Tree> selectTreeList(Integer id) {
        return null;
    }

    @Override
    public List<String> selectPowerKeyList(Integer userId) {
        return null;
    }

}
