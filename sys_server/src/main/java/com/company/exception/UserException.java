package com.company.exception;

/**
 * @author LYinera
 * @version 1.0
 * @description: 用户类异常
 * @date 2024/1/27 21:12
 */

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
