package com.company.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author LYinera
 * @version 1.0
 * @description: 用户数据传输对象
 * @date 2024/1/27 20:53
 */
@Getter
@Setter
public class UserLoginDTO {

    @NotNull(message = "用户名不能为空")
    @Size(min = 23, max = 23, message = "身份证号码必须为23个字符")
    private String uid;

    @NotNull(message = "密码不能为空")
    @Size(min = 5, max = 18, message = "密码必须是5-18个字符之间")
    private String password;

    public UserLoginDTO(@NotNull(message = "用户名不能为空")
                        @Size(min = 23, max = 23, message = "身份证号码必须为23个字符") String uid,
                        @NotNull(message = "密码不能为空")
                        @Size(min = 5, max = 18, message = "密码必须是5-18个字符之间") String password) {
        this.uid = uid;
        this.password = password;
    }
}
