package com.company.utils;

import java.util.Date;


/**
 * @author LYinera
 * @version 1.0
 * @description: 时间戳+三位随机数生成唯一主键ID
 * @date 2024-01-28 13:23
 */
public class IdGenerate {
    public static String getId() {
        Date date = new Date();
        return date.getTime() + "" + ((int) (Math.random() * 900) + 100);
    }
}
