package com.jk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EmpEntity {


    private Integer userId;

    private String userName;

    private Integer userDeptid;

    private Date userCreatetime;

    private String userPost;

    private String userResp;

    private String aa;


    /*业务字段*/

    private String deptName;


}
