package com.example.test.util;

import org.springframework.beans.factory.BeanFactory;

/**
 * @Date:Created by luzy on 2018/7/7.
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array={1,9,40,3,38,6,27,56,69,79,11};
        for(int a:array){
            //当前顺序
            System.out.print(a+"   ");
        }
        System.out.println("   ");
        //冒泡
        for(int i=0;i<array.length-1;i++){//外层循环控制排序趟数
            for(int j=0;j<array.length-1-i;j++){//内层循环控制每一趟排序多少次
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int a:array){
            //当前顺序
            System.out.print(a+"   ");
        }
     //   Thread
    }
}
