package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author LYinera
 * @version 1.0
 * @description: 修改用户密码的DTO
 * @date 2024-01-28 13:26
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePassWDDTO {
    private String uid;
    private String oldPassword;
    private String newPassword;
}
