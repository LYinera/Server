package com.company.controller;

import com.company.common.Result;
import com.company.common.ResultPage;
import com.company.constant.UserConst;
import com.company.dto.UserLoginDTO;
import com.company.dto.UserUpdatePassWDDTO;
import com.company.entity.User;
import com.company.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LYinera
 * @version 1.0
 * @description: 用户控制类
 * @date 2024/1/27 21:09
 */

@RestController
@Api(tags = "用户类接口")
public class UserController {

    @Autowired
    private UserService userService;

    //日志
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    /**
     * @description:
     * @param: userLoginDTO
     * @return: Result
     * @author LYinera
     * @date: 2024/1/25 22:54
     */
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.login(userLoginDTO.getUid(), userLoginDTO.getPassword());
        Result<User> result;
        if (user != null) {
            result = Result.success().setMsg(UserConst.LOGIN_SUCCESS).setData(user);
        } else {
            logger.warn("登陆失败，账号:" + userLoginDTO.getUid() + "密码：" + userLoginDTO.getPassword());
            result = Result.failure().setMsg(UserConst.LOGIN_FAILURE);
        }
        return result;
    }

    @RequestMapping(value = "/deleteUser/{uid}", method = RequestMethod.GET)
    /**
     * @description:
     * @param: uid
     * @return: Result
     * @author LYinera
     * @date: 2024/1/25 22:53
     */
    public Result removeUser(@PathVariable("uid") String uid) {
        userService.removeUserByUid(uid);
        return Result.success().setMsg(UserConst.DELETE_USER_SUCCESS);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    /**
     * @description:
     * @param: user
     * @return: Result
     * @author LYinera
     * @date: 2024/1/25 22:53
     */
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        return Result.success().setMsg(UserConst.ADD_USER_SUCCESS);
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    /**
     * @description:
     * @param: user
     * @return: Result
     * @author LYinera
     * @date: 2024/1/25 22:53
     */
    public Result updateUser(@RequestBody User user) {
        userService.modifyUser(user);
        return Result.success().setMsg(UserConst.UPDATE_USER_SUCCESS);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Result<UserUpdatePassWDDTO> updatePassword(@RequestBody UserUpdatePassWDDTO userUpdatePassWDDTO) {
        User user = userService.login(userUpdatePassWDDTO.getUid(), userUpdatePassWDDTO.getOldPassword());
        Result<UserUpdatePassWDDTO> result;
        if (user != null) {
            userService.updatePassword(userUpdatePassWDDTO.getUid(), userUpdatePassWDDTO.getOldPassword(), userUpdatePassWDDTO.getNewPassword());
            result = Result.success().setMsg(UserConst.LOGIN_SUCCESS).setData(user);
        } else {
            result = Result.failure().setMsg(UserConst.LOGIN_FAILURE);
        }
        return result;
    }

    @RequestMapping(value = "/selectUserByUid/{uid}", method = RequestMethod.GET)
    public Result selectUserByUid(@PathVariable("uid") String uid) {
        User user = userService.getUserByUid(uid);
        if (user != null) {
            return Result.success().setMsg("ok").setData(user);
        } else {
            return Result.failure().setMsg("失败");
        }
    }
}




