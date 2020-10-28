package com.jk.service;

import com.jk.entity.EmpEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "userclient")
public interface EmpService {

    @RequestMapping("emp/findOne")
    public  String findOne();

    @RequestMapping("emp/findAll")
    public List<EmpEntity> findAll(@RequestBody EmpEntity user);

    @RequestMapping("emp/saveUser")
    public void saveUser(@RequestBody EmpEntity user);

    @RequestMapping("emp/HxUser")
    public EmpEntity HxUser(@RequestParam Integer id);


    @RequestMapping("user/delUser")
    public void delUser(@RequestParam Integer id);



}
