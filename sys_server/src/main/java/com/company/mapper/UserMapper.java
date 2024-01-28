package com.company.mapper;

import com.company.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LYinera
 * @version 1.0
 * @description: 用户mapper层接口
 * @date 2024/1/27 21:12
 */
public interface UserMapper {

    /**
     * @description: 通过用户名以及密码查询用户信息
     * @param: username password
     * @return: User
     * @author LYinera
     * @date: 2024/1/27 21:15
     */
    User selectUserByUserNameAndPassword(@Param("uid") String username, @Param("password") String password);

    /**
     * @description: 通过用户名或权限筛选用户
     * @param: username level
     * @return: null
     * @author LYinera
     * @date: 2024/1/27 21:20
     */
    List<User> selectUsers(@Param("username") String username,
                             @Param("level") Integer level);

    /**
     * @description: 通过主键删除数据
     * @param: uid
     * @return: int
     * @author LYinera
     * @date: 2024/1/27 21:19
     */
    int deleteUserByUid(@Param("uid") String uid);

    /**
     * @description: 添加用户
     * @param: user
     * @return: int
     * @author LYinera
     * @date: 2024/1/27 21:18
     */
    int insertUser(User user);

    /**
     * @description: 修改用户信息
     * @param: user
     * @return: int
     * @author LYinera
     * @date: 2024/1/27 21:18
     */
    int updateUser(User user);

    /**
     * @description: 通过主键获取用户信息
     * @param: uid
     * @return: User
     * @author LYinera
     * @date: 2024/1/27 21:18
     */
    User selectUserByUid(String uid);

    /**
     * @description: 通过主键修改密码
     * @param: uid oldPassword newPassword
     * @return: int
     * @author LYinera
     * @date: 2024/1/27 21:15
     */
    int updateUserByPassword(String uid, String oldPassword, String newPassword);
}
