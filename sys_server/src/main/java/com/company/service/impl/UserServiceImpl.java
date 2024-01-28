package com.company.service.impl;

import com.company.entity.User;
import com.company.exception.UserException;
import com.company.mapper.UserMapper;
import com.company.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
/**
 * @description: user Service实现类
 * @author LYinera
 * @date 2024-01-28 13:25
 * @version 1.0
 */ public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User login(String uid, String password) {
        return userMapper.selectUserByUserNameAndPassword(uid, password);
    }


    @Override
    @Transactional
    public boolean addUser(User user) {
        int rows = userMapper.insertUser(user);
        if (rows > 0) {
            return true;
        } else {
            logger.warn("添加用户失败:" + user);
            throw new UserException("添加用户数据失败");
        }
    }

    @Override
    @Transactional
    public boolean modifyUser(User user) {

        int rows = userMapper.updateUser(user);
        if (rows > 0) {
            return true;
        } else {
            logger.warn("修改用户失败" + user);
            throw new UserException("修改用户数据失败");
        }
    }

    @Override
    public User getUserByUid(String uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    @Transactional//开启事务
    public boolean removeUserByUid(String uid) {
        int rows = userMapper.deleteUserByUid(uid);
        if (rows > 0) {
            return true;
        } else {
            logger.warn("UID为" + uid + "的数据删除失败");
            throw new UserException("用户数据删除失败");
        }
    }

    @Override
    public int updatePassword(String uid, String oldPassword, String newPassword) {
        return userMapper.updateUserByPassword(uid, oldPassword, newPassword);
    }
}
