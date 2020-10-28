package com.jk.service.impl;

import com.jk.dao.UserMapper;
import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public SysUser selectUserInfoByCode(String userCode) {
        return userMapper.selectUserInfoByCode(userCode);
    }

    @Override
    public List<Tree> selectTreeList(Integer userId) {
        Integer pid = 1;
        List<Tree> treeList = nodesList(pid, userId);
        return treeList;
    }

    private List<Tree> nodesList(Integer pid, Integer userId){
        List<Tree> treeList = userMapper.selectTreeList(pid, userId);
        for (Tree tree :
                treeList) {
            List<Tree> nodeList = nodesList(tree.getId(), userId);
            // 没有子节点
            if(nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }
        }
        return treeList;
    }



    @Override
    public List<String> selectPowerKeyList(Integer userId) {
        System.out.print(userMapper.selectPowerKeyList(userId));
        return userMapper.selectPowerKeyList(userId);
    }






}
