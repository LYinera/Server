package com.company.entity;

import lombok.*;

/**
 * @author LYinera
 * @version 1.0
 * @description: 用户实体类
 * @date 2024/1/27 20:57
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String idCard;
    private String address;
    private Integer level;
}
