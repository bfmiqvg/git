package com.example.test.util;

/**
 * @Date:Created by luzy on 2018/7/7.
 * @Description: 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] array ,int x){
        int high=array.length-1;
        int low=0;

        while (low<=high){
            int moddle=(high+low)/2;
            int value=array[moddle];
            if(x==value){
                return value;
            }else if(x<value){
                high=moddle-1;
            }else if(x>value){
                low=moddle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array={1,3,8,10,20,57,89,101,308};

        System.out.println(binarySearch(array,58));
    }
}
