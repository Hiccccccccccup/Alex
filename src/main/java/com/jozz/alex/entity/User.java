package com.jozz.alex.entity;

import lombok.Data;

@Data
public class User {
    private Long id;//编号
    private String name;//用户名
    private String pwd;//密码
}
