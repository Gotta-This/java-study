package com.guo.operator;

public class Demo03 {
    public static void main(String[] args) {
        //关系运算符返回的结果为：正确，错误
        //正确，错误就是布尔值表示的
        //关系运算符一般会和if语句一起使用
        int a = 10;
        int b = 10;

        System.out.println(a>b);//false
        System.out.println(a<b);//true
        System.out.println(a==b);//false
        System.out.println(a!=b);//true

        //取余，模运算
        int c = 21;

        System.out.println(c%a);
    }
}
