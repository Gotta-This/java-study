package com.guo.operator;

public class Demo01 {
    public static void main(String[] args) {
        // 二元运算符
        //Ctrl + D   ：  复制当前行到下一行
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);//0
        //由于a = 10，b = 20   10/20=0.5
        //但a是int型的，b也是int型，所以只保留整数0
        //所以需要强行转换为double类型的
        System.out.println(a/(double)b);
    }
}
