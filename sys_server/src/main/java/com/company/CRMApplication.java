package com.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LYinera
 * @version 1.0
 * @description: 启动类
 * @date 2024-01-28 11:44
 */
@SpringBootApplication
@MapperScan("com.company.mapper")
public class CRMApplication {
    public static void main(String[] args) {
        SpringApplication.run(CRMApplication.class, args);
    }
}
