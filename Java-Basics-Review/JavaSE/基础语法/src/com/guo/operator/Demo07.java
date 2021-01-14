package com.guo.operator;

public class Demo07 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a+=b;// a = a + b
        a-=b;// a = a - b

        System.out.println(a);//10

        //字符串连接符  +
        System.out.println(a+b);//30
        System.out.println(""+a+b);//1020
        System.out.println(a+b+"");//30
        //""内是字符串，后面的a和b自动转换成字符串输出
        //如果字符串在前面，则a和b都变成字符串拼接输出
        //如果字符串在后面，则a和b先进行运算，再和字符串拼接输出
    }
}
