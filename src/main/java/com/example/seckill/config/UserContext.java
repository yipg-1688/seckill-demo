package com.example.seckill.config;

import com.example.seckill.pojo.User;

/**
 * @author yipeng
 * @date 2022-03-10
 * @description
 */
public class UserContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }


}
