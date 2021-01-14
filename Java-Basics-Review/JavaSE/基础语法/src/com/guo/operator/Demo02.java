package com.guo.operator;

public class Demo02 {
    public static void main(String[] args) {
        long a = 123123123123123L;
        int b = 123;
        short c = 10;
        byte d = 8;

        System.out.println(a+b+c+d);//变成Long类型的
        System.out.println(b+c+d);//变成Int类型的
        System.out.println(c+d);//变成Int类型的

        //多个数相加，只要有一个数是Long型的，结果就是Long型的
        //只要没一个数是Long型的，结果就是Int型的
        //这个叫  自动升型
    }
}
