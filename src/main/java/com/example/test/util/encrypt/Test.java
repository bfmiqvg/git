package com.example.test.util.encrypt;

import java.util.Scanner;

/**
 * @Date:Created by luzy on 2018/8/3.
 * @Description:
 */
public class Test {
    static char[] directionArray={'E', 'S', 'W', 'N'};
    static char left='L';
    static char right='R';
    static char move='M';
    public static void main(String[] args) {
        System.out.println("请输入当前位置坐标：");
        Scanner scanner=new Scanner(System.in);
        String location = scanner.nextLine();
      //  System.out.println(location);
        String[] array=location.split(" ");
        int x=Integer.valueOf(array[0]) ;
        int y=Integer.valueOf(array[1]) ;
        char currentDirection=array[2].toCharArray()[0]; //当前方向
        System.out.println("请输入指令：");
        scanner=new Scanner(System.in);
        String command = scanner.nextLine();
      //  System.out.println(command);

        char[] chars=command.toCharArray();

        int index=0;    //数组中方向对应的索引
        for(int i=0;i<directionArray.length;i++){
            if(directionArray[i]==currentDirection){
                index=i;
                break;
            }
        }
        char newDirection=currentDirection; //新方向
        int newIndex=index;
        for(char c:chars){
            if(c==left){
                if(newDirection=='E'){
                    newDirection=directionArray[directionArray.length-1];
                    newIndex=directionArray.length-1;
                }else{
                    newDirection=directionArray[newIndex-1];
                    newIndex=newIndex-1;
                }
            }else if(c==right){
                if(newDirection=='N'){
                    newDirection=directionArray[0];
                    newIndex=0;
                }else{
                    newDirection=directionArray[newIndex+1];
                    newIndex=newIndex+1;
                }
            }else if(c==move){
                switch (newDirection){
                    case 'E':
                        x += 1;
                        break;
                    case 'S':
                        y -= 1;
                        break;
                    case 'W':
                        x -= 1;
                        break;
                    case 'N':
                        y += 1;
                        break;
                }
            }
        }

        System.out.println("新的位置："+x+" "+y+" "+ newDirection);
    }
}
