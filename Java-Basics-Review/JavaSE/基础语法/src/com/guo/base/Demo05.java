package com.guo.base;

public class Demo05<main> {
    public static void main(String[] args) {
        //强制类型转换  (类型)变量名  优先级高 -> 低
        int i = 128;
        byte b = (byte)i;//内存溢出问题

        System.out.println(i);
        System.out.println(b);

        //自动类型转换  优先级低 -> 高
        double d = i;

        System.out.println(d);//128.0

        /*
        注意点：
        1. 不能对布尔值进行转换
        2. 不能把对象类型转换为不相干的类型
        3. 在把高容量转换到低容量的时候，强制转换
        4. 转换的时候可能存在内存溢出，或者精度问题
        5. 不同继承体系内的对象不能转换
         */
        System.out.println("========================");
        System.out.println((int)23.7);//23
        System.out.println((int)-45.89f);//-45

        System.out.println("========================");
        char c = 'a';
        int d1 = c + 1;
        System.out.println(d1);//98
        System.out.println((char)98);//b

    }
}
