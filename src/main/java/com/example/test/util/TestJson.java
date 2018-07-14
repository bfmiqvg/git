package com.example.test.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Date:Created by luzy on 2018/7/5.
 * @Description:
 */
public class TestJson {

    public static void main(String[] args) {
        JSONObject rtnJson = JSONObject.parseObject("{'jsonVal':[{'idcard':'','platform':'','Signer1':'','Signer2':'','ctime':'','username':'','Signer3':''}]}");
        System.out.println(rtnJson.getString("jsonVal"));
    }
}
