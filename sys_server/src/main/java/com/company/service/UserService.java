package com.company.service;

import com.company.entity.User;
import java.util.List;

public interface UserService {

    /**
     * @description: 登录
     * @param: username password
     * @return: User
     * @author LYinera
     * @date: 2024/1/27 21:23
     */
    User login(String username, String password);


    /**
     * @description: 通过主键删除用户
     * @param: uid
     * @return: boolean
     * @author LYinera
     * @date: 2024/1/27 21:24
     */
    boolean removeUserByUid(String uid);

    /**
     * @description: 添加用户
     * @param: user
     * @return: boolean
     * @author LYinera
     * @date: 2024/1/27 21:24
     */
    boolean addUser(User user);

    /**
     * @description: 修改用户信息
     * @param: user
     * @return: boolean
     * @author LYinera
     * @date: 2024/1/27 21:24
     */
    boolean modifyUser(User user);


    /**
     * @description: 通过主键获取用户信息
     * @param: uid
     * @return: User
     * @author LYinera
     * @date: 2024/1/27 21:25
     */
    User getUserByUid(String uid);

    /**
     * @description: 修改密码
     * @param: null
     * @return: null
     * @author LYinera
     * @date: 2024/1/27 21:25
     */
    int updatePassword(String uid, String oldPassword, String newPassword);
}
