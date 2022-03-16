package com.example.seckill.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @author yipeng
 * @date 2022-02-17
 * @description MD5工具类
 */
@Component
@Slf4j
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";


    //MD5第一次加密(加盐)
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //MD5第二次加密(加盐)
    public static String formPassToDBPass(String formpass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formpass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //82a693d3173db016d77c59a41d302b20
        log.info("Md5一次加密:" + inputPassToFromPass("123456"));
        //44ee7c245d24ef7afb70d2b3f0779cb3
        log.info("Md5二次加密:" + formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        log.info(inputPassToDBPass("123456", "1a2b3c4d"));

    }

}
