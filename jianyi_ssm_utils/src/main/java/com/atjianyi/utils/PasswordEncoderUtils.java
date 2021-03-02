package com.atjianyi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 简一
 * @className PasswordEncoderUtils
 * @Date 2021/3/2 16:16
 **/
public class PasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String pwdReversToEncode(String password){
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    public static void main(String args[]){
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }
}
