package com.jk.controller;

import com.jk.entity.DeptEntity;
import com.jk.entity.UserEntity;
import com.jk.service.DeptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("user/findAll")
    public List<UserEntity> findAll(@RequestBody DeptEntity dept){
        List<UserEntity> list = deptService.findAll(dept);
        return list;
    }

    /**
     * 新增+修改
     * @param dept
     */
    @RequestMapping("user/saveUser")
    public void addUser(@RequestBody DeptEntity dept){

        if(dept.getDeptId()!=null){
            deptService.updDept(dept);
        }else{
            deptService.addDept(dept);
        }


    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("user/HxUser")
    public UserEntity HxUser(@RequestParam Integer id){
        return deptService.HxDept(id);
    }


    /**
     * 删除
     * @param id
     */
    @RequestMapping("user/delUser")
    public void delUser(@RequestParam Integer id){
        deptService.delDept(id);
    }

}
