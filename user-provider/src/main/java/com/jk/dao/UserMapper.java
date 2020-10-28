package com.jk.dao;

import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    SysUser selectUserInfoByCode(@Param("userCode") String userCode);

    List<Tree> selectTreeList(@Param("pid") Integer pid, @Param("userId") Integer userId);

    List<String> selectPowerKeyList(@Param("userId") Integer userId);
}
