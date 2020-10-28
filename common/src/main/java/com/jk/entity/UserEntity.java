package com.jk.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer userId;
    private String userName;
    private String password;
    private String Salt;
}
