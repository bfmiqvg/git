package com.example.test.util;

import org.springframework.util.StringUtils;

/**
 * @Date:Created by luzy on 2018/8/3.
 * @Description:
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        String a=null;
        String b="";
        String c="   ";
        System.out.println(StringUtils.isEmpty(a));
        System.out.println(StringUtils.isEmpty(b));
        System.out.println(StringUtils.isEmpty(c));



    }
}
