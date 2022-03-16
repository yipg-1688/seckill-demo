package com.example.seckill.utils;

import java.util.UUID;

/**
 * @author yipeng
 * @date 2022-02-22
 * @description UUID工具类
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
