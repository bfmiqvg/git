package com.example.test.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Date:Created by luzy on 2018/7/5.
 * @Description:
 */
public class TestJson {

    public static void main(String[] args) {
        JSONObject rtnJson = JSONObject.parseObject("{'int':1,'int2':'2','str':'a','jsonVal':[{'idcard':'','platform':'','Signer1':'','Signer2':'','ctime':'','username':'','Signer3':''}]}");
        System.out.println(rtnJson.getString("jsonVal"));
        System.out.println(rtnJson.getString("str"));
        System.out.println(rtnJson.getInteger("int"));
   //     System.out.println(rtnJson.getInteger("str"));
        System.out.println(rtnJson.getString("int"));

        System.out.println(rtnJson.getString("int2"));
        System.out.println(rtnJson.getInteger("int2"));

        System.out.println(rtnJson.getString("int3"));
        System.out.println(rtnJson.getInteger("int3"));
    }
}
