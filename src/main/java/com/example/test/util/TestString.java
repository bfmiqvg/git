package com.example.test.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date:Created by luzy on 2018/8/15.
 * @Description: 查出字符串中只出现一次的字符
 */
public class TestString {
    public static char[] dealString(String str){
        char[] array=new char[26];
        int[] intArray=new int[26];
        for(char c:str.toCharArray()){
            intArray[c-'A']+=1;
        }
        int count=0;

        for(int i=0;i<intArray.length;i++){
            if(intArray[i]==1){
                array[count]=(char)(i+'A');
                count++;
            }
        }
        return array;
    }


    public static char[] dealStringByMap(String str){
        Map<Character,Integer> map=new HashMap<>();
        char[] array=new char[26];
        int[] intArray=new int[26];
        for(char c:str.toCharArray()){
            Integer value=map.get(c);
            if(value==null){
                map.put(c,1);
            }else {
                map.put(c,value+1);
            }
        }
        int count=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                array[count]=entry.getKey();
                count++;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(dealString("ABBCBBADFR"));
        System.out.println(dealStringByMap("ABBCBBADFRasddassf"));
    }
}
